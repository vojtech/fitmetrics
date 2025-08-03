package com.fediim.fitmetrics.domain.model

sealed class AuthStatus {
    data class Authenticated(
        val token: FitBitAuthToken
    ) : AuthStatus()

    data object Unauthenticated : AuthStatus()
}
