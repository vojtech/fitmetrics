package com.fediim.fitmetrics.domain.model

import java.time.Instant

data class FitBitAuthToken(
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Long,
    val tokenType: String,
    val scope: String,
    val createdAt: Instant
) {
    fun isExpired(currentTime: Instant = Instant.now()): Boolean {
        val expirationTime = createdAt.plusSeconds(expiresIn)
        return currentTime.isAfter(expirationTime.minusSeconds(60))
    }
}
