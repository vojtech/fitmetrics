package com.fediim.fitmetrics.domain.repository

import com.fediim.fitmetrics.domain.model.Badge
import com.fediim.fitmetrics.domain.model.UserProfile

interface ProfileRepository {
    suspend fun getUserProfile(forceRefresh: Boolean = false): Result<UserProfile>

    suspend fun getUserBadges(forceRefresh: Boolean = false): Result<List<Badge>>
}
