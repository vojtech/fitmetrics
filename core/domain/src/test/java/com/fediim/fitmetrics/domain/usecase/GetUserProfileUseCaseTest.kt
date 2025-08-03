package com.fediim.fitmetrics.domain.usecase

import com.fediim.fitmetrics.domain.model.UserProfile
import com.fediim.fitmetrics.domain.repository.ProfileRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetUserProfileUseCaseTest {
    private val repository: ProfileRepository = mockk()
    private val useCase = GetUserProfileUseCase(repository)

    @Test
    fun `invoke delegates to repository with default flag`() =
        runTest {
            val expected =
                UserProfile(
                    encodedId = "id",
                    displayName = "John",
                    avatar = null,
                    avatar150 = null,
                    avatar640 = null,
                    age = 30,
                    gender = "MALE",
                    distanceUnit = "METRIC",
                    heightUnit = "CM",
                    weightUnit = "KG",
                    temperatureUnit = "C",
                    swimUnit = null,
                    waterUnitName = null,
                    timezone = "UTC",
                    locale = "en_US"
                )
            coEvery { repository.getUserProfile(false) } returns Result.success(expected)

            val result = useCase()

            assertEquals(expected, result.getOrNull())
            coVerify { repository.getUserProfile(false) }
        }

    @Test
    fun `invoke delegates to repository with forceRefresh true`() =
        runTest {
            coEvery {
                repository.getUserProfile(
                    true
                )
            } returns Result.failure(IllegalStateException("x"))
            val result = useCase(true)
            assertEquals(true, result.isFailure)
            coVerify { repository.getUserProfile(true) }
        }
}
