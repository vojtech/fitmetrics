package com.fediim.fitmetrics.domain.usecase

import com.fediim.fitmetrics.domain.model.Badge
import com.fediim.fitmetrics.domain.repository.ProfileRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetUserBadgesUseCaseTest {
    private val repository: ProfileRepository = mockk()
    private val useCase = GetUserBadgesUseCase(repository)

    @Test
    fun `invoke delegates to repository`() =
        runTest {
            val expected = listOf(Badge("type", "name", "desc", null))
            coEvery { repository.getUserBadges(false) } returns Result.success(expected)

            val result = useCase()

            assertEquals(expected, result.getOrNull())
            coVerify { repository.getUserBadges(false) }
        }
}
