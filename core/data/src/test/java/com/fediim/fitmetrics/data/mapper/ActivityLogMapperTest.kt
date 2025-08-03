package com.fediim.fitmetrics.data.mapper

import com.fediim.fitmetrics.data.model.ActiveZoneMinutesDto
import com.fediim.fitmetrics.data.model.ActivityLevelDto
import com.fediim.fitmetrics.data.model.ActivityLogDetailDto
import com.fediim.fitmetrics.data.model.ActivityLogListItemDto
import com.fediim.fitmetrics.data.model.ActivityLogListResponseDto
import com.fediim.fitmetrics.data.model.ActivitySourceDto
import com.fediim.fitmetrics.data.model.HeartRateZoneDto
import com.fediim.fitmetrics.data.model.PaginationDto
import java.time.LocalDate
import org.junit.Assert.assertEquals
import org.junit.Test

class ActivityLogMapperTest {
    private val mapper = ActivityLogMapper()

    @Test
    fun `mapListResponseToDomain maps essential fields`() {
        val dto =
            ActivityLogListResponseDto(
                activities =
                listOf(
                    ActivityLogListItemDto(
                        logId = 1,
                        activityName = "Run",
                        activityTypeId = 90009,
                        activityLevel = listOf(ActivityLevelDto(10, "active")),
                        averageHeartRate = 123,
                        calories = 300,
                        distance = 5.5,
                        distanceUnit = "km",
                        duration = 1800000,
                        activeDuration = 1700000,
                        startTime = "2025-08-01T12:00:00",
                        originalStartTime = "2025-08-01T12:00:00",
                        steps = 6000,
                        logType = "tracker",
                        tcxLink = null,
                        source = ActivitySourceDto("1", "Fitbit", "tracker"),
                        lastModified = "2025-08-01",
                        hasActiveZoneMinutes = true,
                        activeZoneMinutes = ActiveZoneMinutesDto(30, null),
                        heartRateZones = listOf(
                            HeartRateZoneDto(10, 50.0, "fat burn", 90, 120)
                        ),
                        elevationGain = 10.0,
                        caloriesLink = null,
                        heartRateLink = null,
                        speed = 2.5,
                        pace = 5.0
                    )
                ),
                pagination =
                PaginationDto(
                    beforeDate = LocalDate.now().toString(),
                    afterDate = null,
                    limit = 20,
                    next = null,
                    offset = 0,
                    previous = null,
                    sort = "desc"
                )
            )

        val result = mapper.mapListResponseToDomain(dto)

        assertEquals(1, result.size)
        val first = result.first()
        assertEquals(1L, first.logId)
        assertEquals("Run", first.activityName)
        assertEquals(90009, first.activityTypeId)
        assertEquals(300, first.calories)
        assertEquals(5.5, first.distance!!, 0.0001)
        assertEquals("km", first.distanceUnit)
        assertEquals(1800000, first.duration)
        assertEquals(6000, first.steps)
    }

    @Test
    fun `mapDetailToDomain maps date with separate date and time`() {
        val detail =
            ActivityLogDetailDto(
                logId = 5,
                activityId = 1234,
                activityParentId = 12,
                activityParentName = "Cardio",
                name = "Evening Run",
                description = "Nice run",
                calories = 450,
                distance = 6.2,
                duration = 2000000,
                hasStartTime = true,
                isFavorite = false,
                lastModified = "2025-08-01",
                startDate = "2025-08-01",
                startTime = "18:30",
                steps = 7500
            )

        val mapped = mapper.mapDetailToDomain(detail)
        assertEquals(5L, mapped.logId)
        assertEquals(450, mapped.calories)
        assertEquals(6.2, mapped.distance!!, 0.0001)
        assertEquals(2000000, mapped.duration)
        // ensure date composed with time
        assertEquals(2025, mapped.startTime.year)
        assertEquals(8, mapped.startTime.monthValue)
        assertEquals(1, mapped.startTime.dayOfMonth)
        assertEquals(18, mapped.startTime.hour)
        assertEquals(30, mapped.startTime.minute)
    }
}
