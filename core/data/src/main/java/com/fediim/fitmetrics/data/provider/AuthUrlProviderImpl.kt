package com.fediim.fitmetrics.data.provider

import com.fediim.fitmetrics.data.config.AuthConfig
import com.fediim.fitmetrics.domain.usecase.AuthUrlProvider
import javax.inject.Inject

class AuthUrlProviderImpl @Inject constructor(
    private val authConfig: AuthConfig
) : AuthUrlProvider {
    override fun getClientId(): String = authConfig.clientId

    override fun getRedirectUri(): String = authConfig.redirectUri
}
