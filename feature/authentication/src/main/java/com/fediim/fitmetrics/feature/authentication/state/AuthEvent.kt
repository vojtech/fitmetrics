package com.fediim.fitmetrics.feature.authentication.state

sealed class AuthEvent {
    data class AuthCodeReceived(
        val code: String
    ) : AuthEvent()

    data object CheckAuthStatus : AuthEvent()

    data object InitiateAuth : AuthEvent()
}
