package com.fediim.fitmetrics.domain.usecase

import javax.inject.Inject

class GetAuthUrlUseCase
@Inject
constructor(
    private val authUrlProvider: AuthUrlProvider
) {
    operator fun invoke(): String =
        "https://www.fitbit.com/oauth2/authorize?" +
            "response_type=code" +
            "&client_id=${authUrlProvider.getClientId()}" +
            "&redirect_uri=${encodeUri(authUrlProvider.getRedirectUri())}" +
            "&scope=activity%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight"

    private fun encodeUri(uri: String): String =
        uri
            .replace(":", "%3A")
            .replace("/", "%2F")
            .replace(" ", "%20")
}
