package com.fediim.fitmetrics.domain.usecase

import com.fediim.fitmetrics.domain.model.ActivityLogDetail
import com.fediim.fitmetrics.domain.repository.ActivityLogRepository
import javax.inject.Inject

class GetActivityLogByIdUseCase
@Inject
constructor(
    private val repository: ActivityLogRepository
) {
    suspend operator fun invoke(
        logId: Long
    ): Result<ActivityLogDetail> = repository.getActivityLogById(logId)
}
