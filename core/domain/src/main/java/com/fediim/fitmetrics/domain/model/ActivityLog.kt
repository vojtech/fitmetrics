package com.fediim.fitmetrics.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

// Base interface for both types of activity logs
interface ActivityLog {
    val logId: Long
    val calories: Int
    val duration: Long
    val startTime: LocalDateTime
    val steps: Int?
    val distance: Double?
}

// Activity log list item from the list endpoint
data class ActivityLogListItem(
    override val logId: Long,
    val activityName: String,
    val activityTypeId: Int,
    val activityLevel: List<ActivityLevel>,
    val averageHeartRate: Int?,
    override val calories: Int,
    override val distance: Double?,
    val distanceUnit: String?,
    override val duration: Long,
    val activeDuration: Long?,
    override val startTime: LocalDateTime,
    val originalStartTime: LocalDateTime,
    override val steps: Int?,
    val logType: String,
    val tcxLink: String?,
    val source: ActivitySource,
    val lastModified: String,
    val hasActiveZoneMinutes: Boolean?,
    val activeZoneMinutes: ActiveZoneMinutes?,
    val heartRateZones: List<HeartRateZone>?,
    val elevationGain: Double?,
    val caloriesLink: String?,
    val heartRateLink: String?,
    val speed: Double?,
    val pace: Double?
) : ActivityLog

// Activity log detail from the detail endpoint
data class ActivityLogDetail(
    override val logId: Long,
    val activityId: Long,
    val activityParentId: Long,
    val activityParentName: String,
    val name: String,
    val description: String,
    override val calories: Int,
    override val distance: Double?,
    override val duration: Long,
    val hasStartTime: Boolean,
    val isFavorite: Boolean,
    val lastModified: String,
    val startDate: String,
    override val startTime: LocalDateTime,
    override val steps: Int?
) : ActivityLog

data class ActiveZoneMinutes(
    val totalMinutes: Int,
    val minutesInHeartRateZones: List<HeartRateZoneMinutes>?
)

data class HeartRateZoneMinutes(
    val minutes: Int,
    val zoneName: String,
    val order: Int,
    val type: String,
    val minuteMultiplier: Int
)

data class HeartRateZone(
    val minutes: Int,
    val caloriesOut: Double,
    val name: String,
    val min: Int,
    val max: Int
)

data class ActivityType(
    val id: Int,
    val name: String
)

data class ActivityLevel(
    val minutes: Int,
    val name: String
)

data class ActivitySource(
    val id: String,
    val name: String,
    val type: String,
    val url: String?,
    val trackerFeatures: List<String>?
)

data class ActivityLogFilter(
    val startDate: LocalDate? = null,
    val endDate: LocalDate? = null,
    val activityType: Int? = null
)
