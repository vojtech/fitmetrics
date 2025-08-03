package com.fediim.fitmetrics.data.mapper

import com.fediim.fitmetrics.data.local.entity.ActivityLogEntity
import com.fediim.fitmetrics.domain.model.ActiveZoneMinutes
import com.fediim.fitmetrics.domain.model.ActivityLevel
import com.fediim.fitmetrics.domain.model.ActivityLogDetail
import com.fediim.fitmetrics.domain.model.ActivityLogListItem
import com.fediim.fitmetrics.domain.model.ActivitySource
import com.fediim.fitmetrics.domain.model.HeartRateZone
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.serialization.json.Json

/**
 * Mapper for converting between ActivityLogEntity and domain models.
 */
@Singleton
class ActivityLogEntityMapper @Inject constructor() {
    private val json = Json { ignoreUnknownKeys = true }
    private val dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME

    /**
     * Convert a domain ActivityLogListItem to an entity
     */
    fun toEntity(domain: ActivityLogListItem): ActivityLogEntity =
        ActivityLogEntity(
            logId = domain.logId,
            activityName = domain.activityName,
            activityTypeId = domain.activityTypeId,
            activityLevelJson = json.encodeToString(domain.activityLevel),
            averageHeartRate = domain.averageHeartRate,
            calories = domain.calories,
            distance = domain.distance,
            distanceUnit = domain.distanceUnit,
            duration = domain.duration,
            activeDuration = domain.activeDuration,
            startTime = domain.startTime.format(dateTimeFormatter),
            originalStartTime = domain.originalStartTime.format(dateTimeFormatter),
            steps = domain.steps,
            logType = domain.logType,
            tcxLink = domain.tcxLink,
            sourceJson = json.encodeToString(domain.source),
            lastModified = domain.lastModified,
            hasActiveZoneMinutes = domain.hasActiveZoneMinutes,
            activeZoneMinutesJson = domain.activeZoneMinutes?.let { json.encodeToString(it) },
            heartRateZonesJson = domain.heartRateZones?.let { json.encodeToString(it) },
            elevationGain = domain.elevationGain,
            caloriesLink = domain.caloriesLink,
            heartRateLink = domain.heartRateLink,
            speed = domain.speed,
            pace = domain.pace,
            activityId = null,
            activityParentId = null,
            activityParentName = null,
            name = null,
            description = null,
            hasStartTime = null,
            isFavorite = null,
            startDate = null,
            cacheTimestamp = System.currentTimeMillis(),
            cacheType = "LIST"
        )

    /**
     * Convert a domain ActivityLogDetail to an entity
     */
    fun toEntity(domain: ActivityLogDetail): ActivityLogEntity =
        ActivityLogEntity(
            logId = domain.logId,
            activityName = null,
            activityTypeId = null,
            activityLevelJson = null,
            averageHeartRate = null,
            calories = domain.calories,
            distance = domain.distance,
            distanceUnit = null,
            duration = domain.duration,
            activeDuration = null,
            startTime = domain.startTime.format(dateTimeFormatter),
            originalStartTime = null,
            steps = domain.steps,
            logType = null,
            tcxLink = null,
            sourceJson = null,
            lastModified = domain.lastModified,
            hasActiveZoneMinutes = null,
            activeZoneMinutesJson = null,
            heartRateZonesJson = null,
            elevationGain = null,
            caloriesLink = null,
            heartRateLink = null,
            speed = null,
            pace = null,
            activityId = domain.activityId,
            activityParentId = domain.activityParentId,
            activityParentName = domain.activityParentName,
            name = domain.name,
            description = domain.description,
            hasStartTime = domain.hasStartTime,
            isFavorite = domain.isFavorite,
            startDate = domain.startDate,
            cacheTimestamp = System.currentTimeMillis(),
            cacheType = "DETAIL"
        )

    /**
     * Convert an entity to a domain ActivityLogListItem
     */
    fun toActivityLogListItem(entity: ActivityLogEntity): ActivityLogListItem =
        ActivityLogListItem(
            logId = entity.logId,
            activityName = entity.activityName ?: "",
            activityTypeId = entity.activityTypeId ?: 0,
            activityLevel =
            entity.activityLevelJson?.let {
                json.decodeFromString<List<ActivityLevel>>(it)
            } ?: emptyList(),
            averageHeartRate = entity.averageHeartRate,
            calories = entity.calories,
            distance = entity.distance,
            distanceUnit = entity.distanceUnit,
            duration = entity.duration,
            activeDuration = entity.activeDuration,
            startTime = LocalDateTime.parse(entity.startTime, dateTimeFormatter),
            originalStartTime =
            entity.originalStartTime?.let {
                LocalDateTime.parse(it, dateTimeFormatter)
            } ?: LocalDateTime.parse(entity.startTime, dateTimeFormatter),
            steps = entity.steps,
            logType = entity.logType ?: "",
            tcxLink = entity.tcxLink,
            source =
            entity.sourceJson?.let {
                json.decodeFromString<ActivitySource>(it)
            } ?: ActivitySource("", "", "", null, null),
            lastModified = entity.lastModified ?: "",
            hasActiveZoneMinutes = entity.hasActiveZoneMinutes,
            activeZoneMinutes =
            entity.activeZoneMinutesJson?.let {
                json.decodeFromString<ActiveZoneMinutes>(it)
            },
            heartRateZones =
            entity.heartRateZonesJson?.let {
                json.decodeFromString<List<HeartRateZone>>(it)
            },
            elevationGain = entity.elevationGain,
            caloriesLink = entity.caloriesLink,
            heartRateLink = entity.heartRateLink,
            speed = entity.speed,
            pace = entity.pace
        )

    /**
     * Convert an entity to a domain ActivityLogDetail
     */
    fun toActivityLogDetail(entity: ActivityLogEntity): ActivityLogDetail =
        ActivityLogDetail(
            logId = entity.logId,
            activityId = entity.activityId ?: 0L,
            activityParentId = entity.activityParentId ?: 0L,
            activityParentName = entity.activityParentName ?: "",
            name = entity.name ?: "",
            description = entity.description ?: "",
            calories = entity.calories,
            distance = entity.distance,
            duration = entity.duration,
            hasStartTime = entity.hasStartTime ?: false,
            isFavorite = entity.isFavorite ?: false,
            lastModified = entity.lastModified ?: "",
            startDate = entity.startDate ?: "",
            startTime = LocalDateTime.parse(entity.startTime, dateTimeFormatter),
            steps = entity.steps
        )
}
