package com.fediim.fitmetrics.domain.usecase

import com.fediim.fitmetrics.domain.model.FitBitAuthToken
import com.fediim.fitmetrics.domain.repository.FitBitAuthRepository
import java.time.Instant
import javax.inject.Inject

class GetFitBitAuthTokenUseCase
@Inject
constructor(
    private val repository: FitBitAuthRepository
) {
    suspend operator fun invoke(): FitBitAuthToken? = repository.getStoredToken()
}

class ExchangeCodeForTokenUseCase
@Inject
constructor(
    private val repository: FitBitAuthRepository
) {
    suspend operator fun invoke(
        code: String
    ): Result<FitBitAuthToken> = repository.exchangeCodeForToken(code)
}

class RefreshTokenUseCase
@Inject
constructor(
    private val repository: FitBitAuthRepository
) {
    suspend operator fun invoke(
        refreshToken: String
    ): Result<FitBitAuthToken> = repository.refreshToken(refreshToken)
}

class IsTokenExpiredUseCase
@Inject
constructor() {
    operator fun invoke(
        token: FitBitAuthToken,
        currentTime: Instant = Instant.now()
    ): Boolean = token.isExpired(currentTime)
}
