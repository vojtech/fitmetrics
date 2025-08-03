package com.fediim.fitmetrics.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// ActivityLogList response DTOs
@Serializable
data class ActivityLogListResponseDto(
    @SerialName("activities")
    val activities: List<ActivityLogListItemDto>,
    @SerialName("pagination")
    val pagination: PaginationDto
)

@Serializable
data class PaginationDto(
    @SerialName("beforeDate")
    val beforeDate: String?,
    @SerialName("afterDate")
    val afterDate: String?,
    @SerialName("limit")
    val limit: Int,
    @SerialName("next")
    val next: String?,
    @SerialName("offset")
    val offset: Int,
    @SerialName("previous")
    val previous: String?,
    @SerialName("sort")
    val sort: String
)

@Serializable
data class ActivityLogListItemDto(
    @SerialName("logId")
    val logId: Long,
    @SerialName("activityName")
    val activityName: String,
    @SerialName("activityTypeId")
    val activityTypeId: Int,
    @SerialName("activityLevel")
    val activityLevel: List<ActivityLevelDto>,
    @SerialName("averageHeartRate")
    val averageHeartRate: Int? = null,
    @SerialName("calories")
    val calories: Int,
    @SerialName("distance")
    val distance: Double? = null,
    @SerialName("distanceUnit")
    val distanceUnit: String? = null,
    @SerialName("duration")
    val duration: Long,
    @SerialName("activeDuration")
    val activeDuration: Long? = null,
    @SerialName("startTime")
    val startTime: String,
    @SerialName("originalStartTime")
    val originalStartTime: String,
    @SerialName("steps")
    val steps: Int? = null,
    @SerialName("logType")
    val logType: String,
    @SerialName("tcxLink")
    val tcxLink: String? = null,
    @SerialName("source")
    val source: ActivitySourceDto,
    @SerialName("lastModified")
    val lastModified: String,
    @SerialName("hasActiveZoneMinutes")
    val hasActiveZoneMinutes: Boolean? = null,
    @SerialName("activeZoneMinutes")
    val activeZoneMinutes: ActiveZoneMinutesDto? = null,
    @SerialName("heartRateZones")
    val heartRateZones: List<HeartRateZoneDto>? = null,
    @SerialName("elevationGain")
    val elevationGain: Double? = null,
    @SerialName("caloriesLink")
    val caloriesLink: String? = null,
    @SerialName("heartRateLink")
    val heartRateLink: String? = null,
    @SerialName("speed")
    val speed: Double? = null,
    @SerialName("pace")
    val pace: Double? = null
)

@Serializable
data class ActiveZoneMinutesDto(
    @SerialName("totalMinutes")
    val totalMinutes: Int,
    @SerialName("minutesInHeartRateZones")
    val minutesInHeartRateZones: List<HeartRateZoneMinutesDto>? = null
)

@Serializable
data class HeartRateZoneMinutesDto(
    @SerialName("minutes")
    val minutes: Int,
    @SerialName("zoneName")
    val zoneName: String,
    @SerialName("order")
    val order: Int,
    @SerialName("type")
    val type: String,
    @SerialName("minuteMultiplier")
    val minuteMultiplier: Int
)

@Serializable
data class HeartRateZoneDto(
    @SerialName("minutes")
    val minutes: Int,
    @SerialName("caloriesOut")
    val caloriesOut: Double,
    @SerialName("name")
    val name: String,
    @SerialName("min")
    val min: Int,
    @SerialName("max")
    val max: Int
)

// ActivityLog detail response DTOs
@Serializable
data class ActivityLogDetailResponseDto(
    @SerialName("activityLog")
    val activityLog: ActivityLogDetailDto
)

@Serializable
data class ActivityLogDetailDto(
    @SerialName("logId")
    val logId: Long,
    @SerialName("activityId")
    val activityId: Long,
    @SerialName("activityParentId")
    val activityParentId: Long,
    @SerialName("activityParentName")
    val activityParentName: String,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("calories")
    val calories: Int,
    @SerialName("distance")
    val distance: Double? = null,
    @SerialName("duration")
    val duration: Long,
    @SerialName("hasStartTime")
    val hasStartTime: Boolean,
    @SerialName("isFavorite")
    val isFavorite: Boolean,
    @SerialName("lastModified")
    val lastModified: String,
    @SerialName("startDate")
    val startDate: String,
    @SerialName("startTime")
    val startTime: String,
    @SerialName("steps")
    val steps: Int? = null
)

// Common DTOs
@Serializable
data class ActivityLevelDto(
    @SerialName("minutes")
    val minutes: Int,
    @SerialName("name")
    val name: String
)

@Serializable
data class ActivitySourceDto(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String? = null,
    @SerialName("trackerFeatures")
    val trackerFeatures: List<String>? = null
)
