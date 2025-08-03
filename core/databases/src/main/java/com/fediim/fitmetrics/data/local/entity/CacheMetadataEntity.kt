package com.fediim.fitmetrics.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity for storing cache metadata information.
 * This tracks when each cache entry was last updated.
 */
@Entity(tableName = "cache_metadata")
data class CacheMetadataEntity(
    @PrimaryKey
    val key: String,
    val timestamp: Long
)
