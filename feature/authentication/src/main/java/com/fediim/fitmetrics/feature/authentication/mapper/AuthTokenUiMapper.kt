package com.fediim.fitmetrics.feature.authentication.mapper

import com.fediim.fitmetrics.domain.model.FitBitAuthToken
import com.fediim.fitmetrics.feature.authentication.model.AuthTokenUiModel
import javax.inject.Inject

class AuthTokenUiMapper
@Inject
constructor() {
    fun mapToUiModel(token: FitBitAuthToken): AuthTokenUiModel =
        AuthTokenUiModel(
            accessToken = token.accessToken,
            refreshToken = token.refreshToken,
            isExpired = token.isExpired(),
            tokenType = token.tokenType
        )
}
