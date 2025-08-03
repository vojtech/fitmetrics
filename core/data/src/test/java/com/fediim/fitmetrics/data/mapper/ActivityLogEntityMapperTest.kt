package com.fediim.fitmetrics.data.mapper

import com.fediim.fitmetrics.domain.model.ActivityLogDetail
import java.time.LocalDateTime
import org.junit.Assert.assertEquals
import org.junit.Test

class ActivityLogEntityMapperTest {
    private val mapper = ActivityLogEntityMapper()

    @Test
    fun `toActivityLogListItem maps from entity`() {
        val entity =
            com.fediim.fitmetrics.data.local.entity.ActivityLogEntity(
                logId = 10L,
                activityName = "Walk",
                activityTypeId = 123,
                activityLevelJson = null,
                averageHeartRate = 90,
                calories = 100,
                distance = 1.2,
                distanceUnit = "km",
                duration = 600000,
                activeDuration = 500000,
                startTime = "2025-08-01T08:00:00",
                originalStartTime = "2025-08-01T08:00:00",
                steps = 1500,
                logType = "tracker",
                tcxLink = null,
                sourceJson = null,
                lastModified = "2025-08-01",
                hasActiveZoneMinutes = true,
                activeZoneMinutesJson = null,
                heartRateZonesJson = null,
                elevationGain = 2.0,
                caloriesLink = null,
                heartRateLink = null,
                speed = 1.5,
                pace = 10.0,
                activityId = null,
                activityParentId = null,
                activityParentName = null,
                name = null,
                description = null,
                hasStartTime = null,
                isFavorite = null,
                startDate = null,
                cacheTimestamp = 0L,
                cacheType = "LIST"
            )

        val back = mapper.toActivityLogListItem(entity)

        assertEquals(10L, back.logId)
        assertEquals("Walk", back.activityName)
        assertEquals(123, back.activityTypeId)
        assertEquals(100, back.calories)
        assertEquals(1.2, back.distance!!, 0.0001)
        assertEquals(600000, back.duration)
        assertEquals(1500, back.steps)
    }

    @Test
    fun `toEntity from detail and back preserves key fields`() {
        val detail =
            ActivityLogDetail(
                logId = 77L,
                activityId = 9000,
                activityParentId = 9,
                activityParentName = "Parent",
                name = "Ride",
                description = "desc",
                calories = 500,
                distance = 20.0,
                duration = 3600000,
                hasStartTime = true,
                isFavorite = false,
                lastModified = "2025-08-02",
                startDate = "2025-08-02",
                startTime = LocalDateTime.parse("2025-08-02T10:00:00"),
                steps = null
            )

        val entity = mapper.toEntity(detail)
        val back = mapper.toActivityLogDetail(entity)

        assertEquals(detail.logId, back.logId)
        assertEquals(detail.activityId, back.activityId)
        assertEquals(detail.name, back.name)
        assertEquals(detail.calories, back.calories)
        assertEquals(detail.distance, back.distance)
        assertEquals(detail.duration, back.duration)
    }
}
