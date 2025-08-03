package com.fediim.fitmetrics.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserProfileResponseDto(
    val user: UserDto
)

@Serializable
data class UserDto(
    val encodedId: String,
    val displayName: String,
    val avatar: String? = null,
    val avatar150: String? = null,
    val avatar640: String? = null,
    val age: Int? = null,
    val gender: String? = null,
    val distanceUnit: String? = null,
    val height: Double? = null,
    val heightUnit: String? = null,
    val weight: Double? = null,
    val weightUnit: String? = null,
    val temperatureUnit: String? = null,
    val swimUnit: String? = null,
    val waterUnitName: String? = null,
    val timezone: String? = null,
    val locale: String? = null
)
