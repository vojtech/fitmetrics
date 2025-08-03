package com.fediim.fitmetrics.domain.usecase

import com.fediim.fitmetrics.domain.model.AuthStatus
import com.fediim.fitmetrics.domain.model.FitBitAuthToken
import javax.inject.Inject

class AuthenticateUserUseCase @Inject constructor(
    private val getFitBitAuthTokenUseCase: GetFitBitAuthTokenUseCase,
    private val exchangeCodeForTokenUseCase: ExchangeCodeForTokenUseCase,
    private val refreshTokenUseCase: RefreshTokenUseCase
) {
    suspend fun checkAuthStatus(): AuthStatus =
        getFitBitAuthTokenUseCase()?.let { token ->
            if (token.isExpired()) {
                refreshTokenUseCase(token.refreshToken)
                    .fold(
                        onSuccess = { AuthStatus.Authenticated(it) },
                        onFailure = { AuthStatus.Unauthenticated }
                    )
            } else {
                AuthStatus.Authenticated(token)
            }
        } ?: AuthStatus.Unauthenticated

    suspend fun authenticateWithCode(code: String): Result<FitBitAuthToken> = exchangeCodeForTokenUseCase(
        code
    )
}
