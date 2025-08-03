package com.fediim.fitmetrics.domain.usecase

import com.fediim.fitmetrics.domain.model.UserProfile
import com.fediim.fitmetrics.domain.repository.ProfileRepository
import javax.inject.Inject

class GetUserProfileUseCase
@Inject
constructor(
    private val repository: ProfileRepository
) {
    suspend operator fun invoke(
        forceRefresh: Boolean = false
    ): Result<UserProfile> = repository.getUserProfile(forceRefresh)
}
