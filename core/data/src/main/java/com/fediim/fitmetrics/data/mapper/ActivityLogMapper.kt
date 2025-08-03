package com.fediim.fitmetrics.data.mapper

import com.fediim.fitmetrics.data.model.ActiveZoneMinutesDto
import com.fediim.fitmetrics.data.model.ActivityLevelDto
import com.fediim.fitmetrics.data.model.ActivityLogDetailDto
import com.fediim.fitmetrics.data.model.ActivityLogListItemDto
import com.fediim.fitmetrics.data.model.ActivityLogListResponseDto
import com.fediim.fitmetrics.data.model.ActivitySourceDto
import com.fediim.fitmetrics.data.model.HeartRateZoneDto
import com.fediim.fitmetrics.data.model.HeartRateZoneMinutesDto
import com.fediim.fitmetrics.domain.model.ActiveZoneMinutes
import com.fediim.fitmetrics.domain.model.ActivityLevel
import com.fediim.fitmetrics.domain.model.ActivityLogDetail
import com.fediim.fitmetrics.domain.model.ActivityLogListItem
import com.fediim.fitmetrics.domain.model.ActivitySource
import com.fediim.fitmetrics.domain.model.HeartRateZone
import com.fediim.fitmetrics.domain.model.HeartRateZoneMinutes
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import javax.inject.Inject

class ActivityLogMapper @Inject constructor() {
    private val dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    private val dateFormatter = DateTimeFormatter.ISO_DATE

    // Map list response
    fun mapListResponseToDomain(dto: ActivityLogListResponseDto): List<ActivityLogListItem> =
        dto.activities.map { mapListItemToDomain(it) }

    // Map detail response
    fun mapDetailToDomain(dto: ActivityLogDetailDto): ActivityLogDetail =
        ActivityLogDetail(
            logId = dto.logId,
            activityId = dto.activityId,
            activityParentId = dto.activityParentId,
            activityParentName = dto.activityParentName,
            name = dto.name,
            description = dto.description,
            calories = dto.calories,
            distance = dto.distance,
            duration = dto.duration,
            hasStartTime = dto.hasStartTime,
            isFavorite = dto.isFavorite,
            lastModified = dto.lastModified,
            startDate = dto.startDate,
            startTime = parseDateTime(dto.startTime, dto.startDate),
            steps = dto.steps
        )

    // Map list item
    private fun mapListItemToDomain(dto: ActivityLogListItemDto): ActivityLogListItem =
        ActivityLogListItem(
            logId = dto.logId,
            activityName = dto.activityName,
            activityTypeId = dto.activityTypeId,
            activityLevel = dto.activityLevel.map { mapActivityLevelToDomain(it) },
            averageHeartRate = dto.averageHeartRate,
            calories = dto.calories,
            distance = dto.distance,
            distanceUnit = dto.distanceUnit,
            duration = dto.duration,
            activeDuration = dto.activeDuration,
            startTime = parseDateTime(dto.startTime, null),
            originalStartTime = parseDateTime(dto.originalStartTime, null),
            steps = dto.steps,
            logType = dto.logType,
            tcxLink = dto.tcxLink,
            source = mapActivitySourceToDomain(dto.source),
            lastModified = dto.lastModified,
            hasActiveZoneMinutes = dto.hasActiveZoneMinutes,
            activeZoneMinutes = dto.activeZoneMinutes?.let { mapActiveZoneMinutesToDomain(it) },
            heartRateZones = dto.heartRateZones?.map { mapHeartRateZoneToDomain(it) },
            elevationGain = dto.elevationGain,
            caloriesLink = dto.caloriesLink,
            heartRateLink = dto.heartRateLink,
            speed = dto.speed,
            pace = dto.pace
        )

    private fun mapActiveZoneMinutesToDomain(dto: ActiveZoneMinutesDto): ActiveZoneMinutes =
        ActiveZoneMinutes(
            totalMinutes = dto.totalMinutes,
            minutesInHeartRateZones = dto.minutesInHeartRateZones?.map {
                mapHeartRateZoneMinutesToDomain(
                    it
                )
            }
        )

    private fun mapHeartRateZoneMinutesToDomain(dto: HeartRateZoneMinutesDto): HeartRateZoneMinutes =
        HeartRateZoneMinutes(
            minutes = dto.minutes,
            zoneName = dto.zoneName,
            order = dto.order,
            type = dto.type,
            minuteMultiplier = dto.minuteMultiplier
        )

    private fun mapHeartRateZoneToDomain(dto: HeartRateZoneDto): HeartRateZone =
        HeartRateZone(
            minutes = dto.minutes,
            caloriesOut = dto.caloriesOut,
            name = dto.name,
            min = dto.min,
            max = dto.max
        )

    private fun mapActivityLevelToDomain(dto: ActivityLevelDto): ActivityLevel =
        ActivityLevel(
            minutes = dto.minutes,
            name = dto.name
        )

    private fun mapActivitySourceToDomain(dto: ActivitySourceDto): ActivitySource =
        ActivitySource(
            id = dto.id,
            name = dto.name,
            type = dto.type,
            url = dto.url,
            trackerFeatures = dto.trackerFeatures
        )

    private fun parseDateTime(
        timeString: String,
        dateString: String?
    ): LocalDateTime {
        try {
            // First try to parse as ISO date-time
            return LocalDateTime.parse(timeString, dateTimeFormatter)
        } catch (e: DateTimeParseException) {
            // If that fails, try to parse as time only
            try {
                val time = LocalTime.parse(timeString, timeFormatter)
                // If we have a date string, combine it with the time
                if (dateString != null) {
                    val date = LocalDate.parse(dateString, dateFormatter)
                    return LocalDateTime.of(date, time)
                } else {
                    // If no date string, use current date
                    return LocalDateTime.of(LocalDate.now(), time)
                }
            } catch (e: DateTimeParseException) {
                // If all parsing fails, throw the original exception
                throw e
            }
        }
    }
}
