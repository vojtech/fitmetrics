package com.fediim.fitmetrics.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey val encodedId: String,
    val displayName: String,
    val avatar: String?,
    val avatar150: String?,
    val avatar640: String?,
    val age: Int?,
    val gender: String?,
    val distanceUnit: String?,
    val heightUnit: String?,
    val weightUnit: String?,
    val temperatureUnit: String?,
    val swimUnit: String?,
    val waterUnitName: String?,
    val timezone: String?,
    val locale: String?,
    val cacheTimestamp: Long
)
