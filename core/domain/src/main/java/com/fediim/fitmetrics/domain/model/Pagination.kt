package com.fediim.fitmetrics.domain.model

import java.time.LocalDate

/**
 * Represents pagination information for activity logs
 */
data class Pagination(
    val beforeDate: LocalDate?,
    val afterDate: LocalDate?,
    val limit: Int,
    val offset: Int,
    val hasNext: Boolean,
    val hasPrevious: Boolean,
    val sort: String
)

/**
 * Represents a paginated result containing both the data and pagination information
 */
data class PaginatedActivityLogs(
    val activities: List<ActivityLogListItem>,
    val pagination: Pagination
)
