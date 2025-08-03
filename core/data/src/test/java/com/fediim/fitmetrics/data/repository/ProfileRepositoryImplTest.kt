package com.fediim.fitmetrics.data.repository

import com.fediim.fitmetrics.data.local.dao.BadgeDao
import com.fediim.fitmetrics.data.local.dao.UserProfileDao
import com.fediim.fitmetrics.data.local.entity.UserProfileEntity
import com.fediim.fitmetrics.data.model.BadgeDto
import com.fediim.fitmetrics.data.model.BadgesResponseDto
import com.fediim.fitmetrics.data.model.UserDto
import com.fediim.fitmetrics.data.model.UserProfileResponseDto
import com.fediim.fitmetrics.data.remote.FitBitProfileApi
import com.fediim.fitmetrics.domain.model.FitBitAuthToken
import com.fediim.fitmetrics.domain.repository.FitBitAuthRepository
import io.mockk.Called
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ProfileRepositoryImplTest {
    private val api: FitBitProfileApi = mockk()
    private val authRepo: FitBitAuthRepository = mockk()
    private val userDao: UserProfileDao = mockk(relaxed = true)
    private val badgeDao: BadgeDao = mockk(relaxed = true)

    private val repository = ProfileRepositoryImpl(api, authRepo, userDao, badgeDao)

    private fun token(expired: Boolean = false) =
        FitBitAuthToken(
            accessToken = "access",
            refreshToken = "refresh",
            expiresIn = if (expired) 1 else 3600,
            tokenType = "Bearer",
            scope = "*",
            createdAt =
            if (expired) {
                java.time.Instant
                    .now()
                    .minusSeconds(10_000)
            } else {
                java.time.Instant.now()
            }
        )

    @Test
    fun `getUserProfile returns cached when fresh and not forced`() =
        runTest {
            val cached =
                UserProfileEntity(
                    encodedId = "e",
                    displayName = "User",
                    avatar = null,
                    avatar150 = null,
                    avatar640 = null,
                    age = 20,
                    gender = "FEMALE",
                    distanceUnit = "METRIC",
                    heightUnit = "CM",
                    weightUnit = "KG",
                    temperatureUnit = null,
                    swimUnit = null,
                    waterUnitName = null,
                    timezone = "UTC",
                    locale = "en",
                    cacheTimestamp = System.currentTimeMillis()
                )
            coEvery { userDao.getProfile() } returns cached

            val result = repository.getUserProfile(forceRefresh = false)

            assertEquals(cached.displayName, result.getOrNull()?.displayName)
            coVerify { api wasNot Called }
        }

    @Test
    fun `getUserProfile fetches network and caches when forced`() =
        runTest {
            val cached: UserProfileEntity? = null
            coEvery { userDao.getProfile() } returns cached
            coEvery { authRepo.getStoredToken() } returns token(expired = false)
            coEvery { api.getUserProfile(any()) } returns
                Result.success(
                    UserProfileResponseDto(
                        user =
                        UserDto(
                            encodedId = "e",
                            displayName = "User",
                            age = 22,
                            gender = "MALE",
                            avatar = null,
                            avatar150 = null,
                            avatar640 = null,
                            distanceUnit = "METRIC",
                            height = null,
                            heightUnit = "CM",
                            weight = null,
                            weightUnit = "KG",
                            temperatureUnit = null,
                            swimUnit = null,
                            waterUnitName = null,
                            timezone = "UTC",
                            locale = "en"
                        )
                    )
                )

            val result = repository.getUserProfile(forceRefresh = true)

            assertEquals("User", result.getOrNull()?.displayName)
            coVerify { userDao.insertOrUpdate(any()) }
        }

    @Test
    fun `getUserBadges fetches and saves to dao`() =
        runTest {
            coEvery { badgeDao.getBadges() } returns emptyList()
            coEvery { authRepo.getStoredToken() } returns token(expired = false)
            coEvery { api.getUserBadges(any()) } returns
                Result.success(
                    BadgesResponseDto(listOf(BadgeDto("type", "name", "desc", null)))
                )

            val result = repository.getUserBadges(false)

            assertEquals(1, result.getOrNull()?.size)
            coVerify { badgeDao.clear() }
            coVerify { badgeDao.insertAll(match { it.size == 1 && it.first().name == "name" }) }
        }
}
