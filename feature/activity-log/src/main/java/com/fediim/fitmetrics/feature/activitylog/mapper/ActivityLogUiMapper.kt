package com.fediim.fitmetrics.feature.activitylog.mapper

import com.fediim.fitmetrics.domain.model.ActivityLogDetail
import com.fediim.fitmetrics.domain.model.ActivityLogFilter
import com.fediim.fitmetrics.domain.model.ActivityLogListItem
import com.fediim.fitmetrics.feature.activitylog.model.ActivityLogFilterUiModel
import com.fediim.fitmetrics.feature.activitylog.model.ActivityLogUiModel
import java.time.Duration
import javax.inject.Inject

class ActivityLogUiMapper
@Inject
constructor() {
    fun mapListItemToUiModel(domain: ActivityLogListItem): ActivityLogUiModel {
        val duration = formatDuration(domain.duration)
        val distance = domain.distance?.let { "${it.toInt()} ${domain.distanceUnit ?: ""}" }
        val steps = domain.steps?.let { "$it steps" }
        val heartRate = domain.averageHeartRate?.let { "$it bpm" }

        return ActivityLogUiModel(
            id = domain.logId,
            name = domain.activityName,
            typeId = domain.activityTypeId,
            calories = domain.calories,
            duration = duration,
            distance = distance,
            steps = steps,
            startTime = domain.startTime,
            heartRate = heartRate
        )
    }

    fun mapDetailToUiModel(domain: ActivityLogDetail): ActivityLogUiModel {
        val duration = formatDuration(domain.duration)
        val distance = domain.distance?.let { "${it.toInt()}" }
        val steps = domain.steps?.let { "$it steps" }

        return ActivityLogUiModel(
            id = domain.logId,
            name = domain.name,
            typeId = domain.activityId.toInt(),
            calories = domain.calories,
            duration = duration,
            distance = distance,
            steps = steps,
            startTime = domain.startTime,
            heartRate = null // Detail doesn't include heart rate
        )
    }

    fun mapToDomainFilter(ui: ActivityLogFilterUiModel): ActivityLogFilter =
        ActivityLogFilter(
            startDate = ui.startDate,
            endDate = ui.endDate,
            activityType = ui.activityType?.id?.takeIf { it > 0 }
        )

    private fun formatDuration(durationInMillis: Long): String {
        val duration = Duration.ofMillis(durationInMillis)
        val hours = duration.toHours()
        val minutes = (duration.toMinutes() % 60).toInt()
        val seconds = (duration.seconds % 60).toInt()

        return when {
            hours > 0 -> String.format("%d:%02d:%02d", hours, minutes, seconds)
            else -> String.format("%d:%02d", minutes, seconds)
        }
    }
}
