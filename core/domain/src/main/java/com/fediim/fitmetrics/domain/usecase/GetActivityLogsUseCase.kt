package com.fediim.fitmetrics.domain.usecase

import com.fediim.fitmetrics.domain.model.ActivityLogFilter
import com.fediim.fitmetrics.domain.model.PaginatedActivityLogs
import com.fediim.fitmetrics.domain.repository.ActivityLogRepository
import javax.inject.Inject

class GetActivityLogsUseCase @Inject constructor(
    private val repository: ActivityLogRepository
) {
    /**
     * Get paginated activity logs
     *
     * @param filter Optional filter parameters
     * @param offset Pagination offset (starting position)
     * @param limit Maximum number of items to return
     * @return Result containing paginated activity logs or an error
     */
    suspend operator fun invoke(
        filter: ActivityLogFilter? = null,
        offset: Int = 0,
        limit: Int = 20
    ): Result<PaginatedActivityLogs> = repository.getActivityLogs(filter, offset, limit)
}
