package com.fediim.fitmetrics.domain.usecase

interface AuthUrlProvider {
    fun getClientId(): String

    fun getRedirectUri(): String
}
