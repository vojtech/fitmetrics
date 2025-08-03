package com.fediim.fitmetrics.domain.usecase

import com.fediim.fitmetrics.domain.model.ActivityType
import com.fediim.fitmetrics.domain.repository.ActivityLogRepository
import javax.inject.Inject

class GetActivityTypesUseCase
@Inject
constructor(
    private val repository: ActivityLogRepository
) {
    suspend operator fun invoke(): Result<List<ActivityType>> = repository.getActivityTypes()
}
