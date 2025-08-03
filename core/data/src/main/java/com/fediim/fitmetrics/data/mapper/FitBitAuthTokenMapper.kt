package com.fediim.fitmetrics.data.mapper

import com.fediim.fitmetrics.data.model.FitBitAuthTokenDto
import com.fediim.fitmetrics.domain.model.FitBitAuthToken
import java.time.Instant
import javax.inject.Inject

class FitBitAuthTokenMapper @Inject constructor() {
    fun mapToDomain(
        dto: FitBitAuthTokenDto,
        createdAt: Instant = Instant.now()
    ): FitBitAuthToken =
        FitBitAuthToken(
            accessToken = dto.accessToken,
            refreshToken = dto.refreshToken,
            expiresIn = dto.expiresIn,
            tokenType = dto.tokenType,
            scope = dto.scope,
            createdAt = createdAt
        )
}
