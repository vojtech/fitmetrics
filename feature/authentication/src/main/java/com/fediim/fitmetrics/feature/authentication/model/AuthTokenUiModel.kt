package com.fediim.fitmetrics.feature.authentication.model

data class AuthTokenUiModel(
    val accessToken: String,
    val refreshToken: String,
    val isExpired: Boolean,
    val tokenType: String
)
