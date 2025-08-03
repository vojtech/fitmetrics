package com.fediim.fitmetrics.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fediim.fitmetrics.data.local.entity.CacheMetadataEntity

/**
 * Data Access Object for cache metadata operations.
 */
@Dao
interface CacheMetadataDao {
    /**
     * Get metadata for a specific cache key
     * @param key The cache key
     * @return The metadata entity or null if not found
     */
    @Query("SELECT * FROM cache_metadata WHERE `key` = :key")
    suspend fun getMetadata(key: String): CacheMetadataEntity?

    /**
     * Insert or update metadata for a cache key
     * @param metadata The metadata entity to insert or update
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(metadata: CacheMetadataEntity)

    /**
     * Delete metadata for a specific cache key
     * @param key The cache key
     */
    @Query("DELETE FROM cache_metadata WHERE `key` = :key")
    suspend fun deleteMetadata(key: String)

    /**
     * Delete all metadata older than a specific timestamp
     * @param timestamp The timestamp threshold
     * @return The number of rows deleted
     */
    @Query("DELETE FROM cache_metadata WHERE timestamp < :timestamp")
    suspend fun deleteOlderThan(timestamp: Long): Int
}
