package com.fediim.fitmetrics.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fediim.fitmetrics.data.local.entity.ActivityLogEntity

/**
 * Data Access Object for activity log operations.
 */
@Dao
interface ActivityLogDao {
    /**
     * Get all activity logs with optional filtering
     * @param startDate Optional start date filter
     * @param endDate Optional end date filter
     * @param activityTypeId Optional activity type filter
     * @param limit Maximum number of logs to return
     * @param offset Pagination offset
     * @return List of activity log entities
     */
    @Query(
        """
        SELECT * FROM activity_logs
        WHERE (:startDate IS NULL OR startTime >= :startDate)
        AND (:endDate IS NULL OR startTime <= :endDate)
        AND (:activityTypeId IS NULL OR activityTypeId = :activityTypeId)
        AND cacheType = 'LIST'
        ORDER BY startTime DESC
        LIMIT :limit OFFSET :offset
    """
    )
    suspend fun getActivityLogs(
        startDate: String? = null,
        endDate: String? = null,
        activityTypeId: Int? = null,
        limit: Int = 20,
        offset: Int = 0
    ): List<ActivityLogEntity>

    /**
     * Get a specific activity log by ID
     * @param logId The ID of the activity log
     * @return The activity log entity or null if not found
     */
    @Query("SELECT * FROM activity_logs WHERE logId = :logId")
    suspend fun getActivityLogById(logId: Long): ActivityLogEntity?

    /**
     * Insert or update activity logs
     * @param logs The activity log entities to insert or update
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateActivityLogs(vararg logs: ActivityLogEntity)

    /**
     * Delete activity logs older than a specific timestamp
     * @param timestamp The timestamp threshold
     * @return The number of rows deleted
     */
    @Query("DELETE FROM activity_logs WHERE cacheTimestamp < :timestamp")
    suspend fun deleteOlderThan(timestamp: Long): Int

    /**
     * Delete all activity logs
     */
    @Query("DELETE FROM activity_logs")
    suspend fun deleteAll()
}
