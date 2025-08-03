package com.fediim.fitmetrics.feature.activitylog.mapper

import com.fediim.fitmetrics.domain.model.ActivityLevel
import com.fediim.fitmetrics.domain.model.ActivityLogDetail
import com.fediim.fitmetrics.domain.model.ActivityLogListItem
import com.fediim.fitmetrics.domain.model.ActivitySource
import java.time.LocalDateTime
import org.junit.Assert.assertEquals
import org.junit.Test

class ActivityLogUiMapperTest {
    private val mapper = ActivityLogUiMapper()

    @Test
    fun `mapListItemToUiModel formats fields`() {
        val item =
            ActivityLogListItem(
                logId = 1,
                activityName = "Run",
                activityTypeId = 2,
                activityLevel = listOf(ActivityLevel(10, "active")),
                averageHeartRate = 120,
                calories = 250,
                distance = 5000.0,
                distanceUnit = "m",
                duration = 90_000,
                activeDuration = null,
                startTime = LocalDateTime.parse("2025-08-01T07:00:00"),
                originalStartTime = LocalDateTime.parse("2025-08-01T07:00:00"),
                steps = 4000,
                logType = "tracker",
                tcxLink = null,
                source = ActivitySource("1", "Fitbit", "tracker", null, null),
                lastModified = "",
                hasActiveZoneMinutes = null,
                activeZoneMinutes = null,
                heartRateZones = null,
                elevationGain = null,
                caloriesLink = null,
                heartRateLink = null,
                speed = null,
                pace = null
            )

        val ui = mapper.mapListItemToUiModel(item)
        assertEquals("Run", ui.name)
        assertEquals("1:30", ui.duration)
        assertEquals("5000 m", ui.distance)
        assertEquals("4000 steps", ui.steps)
        assertEquals("120 bpm", ui.heartRate)
    }

    @Test
    fun `mapDetailToUiModel formats fields`() {
        val detail =
            ActivityLogDetail(
                logId = 2,
                activityId = 100,
                activityParentId = 10,
                activityParentName = "Cardio",
                name = "Ride",
                description = "desc",
                calories = 600,
                distance = 42.0,
                duration = 3_600_000,
                hasStartTime = true,
                isFavorite = false,
                lastModified = "",
                startDate = "2025-08-01",
                startTime = LocalDateTime.parse("2025-08-01T09:00:00"),
                steps = null
            )

        val ui = mapper.mapDetailToUiModel(detail)
        assertEquals("Ride", ui.name)
        assertEquals("1:00:00", ui.duration.takeLast(7))
        assertEquals("42", ui.distance)
        assertEquals(null, ui.heartRate)
    }
}
