package com.fediim.fitmetrics.domain.repository

import com.fediim.fitmetrics.domain.model.FitBitAuthToken

interface FitBitAuthRepository {
    suspend fun getStoredToken(): FitBitAuthToken?

    suspend fun saveToken(token: FitBitAuthToken)

    suspend fun clearToken()

    suspend fun exchangeCodeForToken(code: String): Result<FitBitAuthToken>

    suspend fun refreshToken(refreshToken: String): Result<FitBitAuthToken>
}
