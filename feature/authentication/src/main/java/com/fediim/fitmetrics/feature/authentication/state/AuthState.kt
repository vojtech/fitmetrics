package com.fediim.fitmetrics.feature.authentication.state

sealed class AuthState {
    data object Initial : AuthState()

    data object Loading : AuthState()

    data object Authenticated : AuthState()

    data class Error(
        val error: Throwable
    ) : AuthState()
}
