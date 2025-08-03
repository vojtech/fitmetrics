package com.fediim.fitmetrics.domain.model

/**
 * Minimal domain model for Fitbit User Profile with unit settings needed in the app.
 */
data class UserProfile(
    val encodedId: String,
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
    val locale: String?
)
