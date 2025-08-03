package com.fediim.fitmetrics.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.fediim.fitmetrics.data.local.converter.DateTimeConverters

/**
 * Entity for storing activity log data in the database.
 * This is a simplified version that contains the essential fields.
 * Complex nested objects are stored as JSON strings.
 */
@Entity(tableName = "activity_logs")
@TypeConverters(DateTimeConverters::class)
data class ActivityLogEntity(
    @PrimaryKey
    val logId: Long,
    val activityName: String?,
    val activityTypeId: Int?,
    val activityLevelJson: String?,
    val averageHeartRate: Int?,
    val calories: Int,
    val distance: Double?,
    val distanceUnit: String?,
    val duration: Long,
    val activeDuration: Long?,
    val startTime: String,
    val originalStartTime: String?,
    val steps: Int?,
    val logType: String?,
    val tcxLink: String?,
    val sourceJson: String?,
    val lastModified: String?,
    val hasActiveZoneMinutes: Boolean?,
    val activeZoneMinutesJson: String?,
    val heartRateZonesJson: String?,
    val elevationGain: Double?,
    val caloriesLink: String?,
    val heartRateLink: String?,
    val speed: Double?,
    val pace: Double?,
    val activityId: Long?,
    val activityParentId: Long?,
    val activityParentName: String?,
    val name: String?,
    val description: String?,
    val hasStartTime: Boolean?,
    val isFavorite: Boolean?,
    val startDate: String?,
    val cacheTimestamp: Long,
    val cacheType: String
)
