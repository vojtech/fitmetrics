package com.fediim.fitmetrics.domain.model

data class Badge(
    val badgeType: String,
    val name: String,
    val description: String?,
    val imageUrl: String?
)
