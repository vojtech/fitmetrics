package com.fediim.fitmetrics.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fediim.fitmetrics.data.local.converter.DateTimeConverters
import com.fediim.fitmetrics.data.local.dao.ActivityLogDao
import com.fediim.fitmetrics.data.local.dao.BadgeDao
import com.fediim.fitmetrics.data.local.dao.CacheMetadataDao
import com.fediim.fitmetrics.data.local.dao.UserProfileDao
import com.fediim.fitmetrics.data.local.entity.ActivityLogEntity
import com.fediim.fitmetrics.data.local.entity.BadgeEntity
import com.fediim.fitmetrics.data.local.entity.CacheMetadataEntity
import com.fediim.fitmetrics.data.local.entity.UserProfileEntity

/**
 * Main database class for the application.
 * This database holds all local data including cache metadata and activity logs.
 */
@Database(
    entities = [
        CacheMetadataEntity::class,
        ActivityLogEntity::class,
        UserProfileEntity::class,
        BadgeEntity::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(DateTimeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Get the DAO for cache metadata operations
     */
    abstract fun cacheMetadataDao(): CacheMetadataDao

    /**
     * Get the DAO for activity log operations
     */
    abstract fun activityLogDao(): ActivityLogDao

    /**
     * Get the DAO for user profile operations
     */
    abstract fun userProfileDao(): UserProfileDao

    /**
     * Get the DAO for badges operations
     */
    abstract fun badgeDao(): BadgeDao
}
