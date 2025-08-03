package com.fediim.fitmetrics.domain.usecase

import com.fediim.fitmetrics.domain.model.Badge
import com.fediim.fitmetrics.domain.repository.ProfileRepository
import javax.inject.Inject

class GetUserBadgesUseCase
@Inject
constructor(
    private val repository: ProfileRepository
) {
    suspend operator fun invoke(
        forceRefresh: Boolean = false
    ): Result<List<Badge>> = repository.getUserBadges(forceRefresh)
}
