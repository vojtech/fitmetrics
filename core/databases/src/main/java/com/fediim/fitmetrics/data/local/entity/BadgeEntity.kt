package com.fediim.fitmetrics.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "badges")
data class BadgeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val badgeType: String,
    val name: String,
    val description: String?,
    val imageUrl: String?,
    val cacheTimestamp: Long
)
