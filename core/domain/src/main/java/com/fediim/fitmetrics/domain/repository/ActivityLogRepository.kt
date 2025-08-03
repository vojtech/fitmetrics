package com.fediim.fitmetrics.domain.repository

import com.fediim.fitmetrics.domain.model.ActivityLogDetail
import com.fediim.fitmetrics.domain.model.ActivityLogFilter
import com.fediim.fitmetrics.domain.model.ActivityType
import com.fediim.fitmetrics.domain.model.PaginatedActivityLogs

interface ActivityLogRepository {
    /**
     * Get activity logs for the authenticated user
     * @param filter Optional filter parameters
     * @param offset Pagination offset (starting position)
     * @param limit Maximum number of items to return
     * @return Result containing paginated activity logs or an error
     */
    suspend fun getActivityLogs(
        filter: ActivityLogFilter? = null,
        offset: Int = 0,
        limit: Int = 20
    ): Result<PaginatedActivityLogs>

    /**
     * Get a specific activity log by its ID
     * @param logId The ID of the activity log to retrieve
     * @return Result containing the activity log detail or an error
     */
    suspend fun getActivityLogById(logId: Long): Result<ActivityLogDetail>

    /**
     * Get unique activity types from the user's activity logs
     * @return Result containing a list of activity types or an error
     */
    suspend fun getActivityTypes(): Result<List<ActivityType>>
}
