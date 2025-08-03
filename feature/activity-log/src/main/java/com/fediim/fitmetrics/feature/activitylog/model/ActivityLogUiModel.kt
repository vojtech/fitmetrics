package com.fediim.fitmetrics.feature.activitylog.model

import java.time.LocalDate
import java.time.LocalDateTime

data class ActivityLogUiModel(
    val id: Long,
    val name: String,
    val typeId: Int,
    val calories: Int,
    val duration: String,
    val distance: String?,
    val steps: String?,
    val startTime: LocalDateTime,
    val heartRate: String?
)

data class ActivityLogFilterUiModel(
    val startDate: LocalDate? = null,
    val endDate: LocalDate? = null,
    val activityType: ActivityTypeUiModel? = null,
    val isCalendarVisible: Boolean = false,
    val isQuickFilterVisible: Boolean = true
)

data class ActivityTypeUiModel(
    val id: Int,
    val name: String
)
