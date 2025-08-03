package com.fediim.fitmetrics.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BadgesResponseDto(
    val badges: List<BadgeDto>
)

@Serializable
data class BadgeDto(
    val badgeType: String,
    val name: String,
    val description: String? = null,
    val image100px: String? = null
)
