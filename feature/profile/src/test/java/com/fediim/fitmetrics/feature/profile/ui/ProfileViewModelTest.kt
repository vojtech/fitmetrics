package com.fediim.fitmetrics.feature.profile.ui

import com.fediim.fitmetrics.domain.model.Badge
import com.fediim.fitmetrics.domain.model.UserProfile
import com.fediim.fitmetrics.domain.usecase.GetUserBadgesUseCase
import com.fediim.fitmetrics.domain.usecase.GetUserProfileUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProfileViewModelTest {
    private val getProfile: GetUserProfileUseCase = mockk()
    private val getBadges: GetUserBadgesUseCase = mockk()

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `init loads profile and badges into state`() =
        runTest {
            val profile =
                UserProfile(
                    encodedId = "e",
                    displayName = "User",
                    avatar = null,
                    avatar150 = null,
                    avatar640 = null,
                    age = 30,
                    gender = "MALE",
                    distanceUnit = "METRIC",
                    heightUnit = "CM",
                    weightUnit = "KG",
                    temperatureUnit = null,
                    swimUnit = null,
                    waterUnitName = null,
                    timezone = "UTC",
                    locale = "en"
                )
            val badges = listOf(Badge("type", "name", "desc", null))

            coEvery { getProfile(any()) } returns Result.success(profile)
            coEvery { getBadges(any()) } returns Result.success(badges)

            val vm = ProfileViewModel(getProfile, getBadges)

            // allow init to run
            advanceUntilIdle()
            val state = vm.state.value
            assertEquals(false, state.isLoading)
            assertEquals("User", state.profile?.displayName)
            assertEquals(1, state.badges.size)
            assertEquals(null, state.error)
        }
}
