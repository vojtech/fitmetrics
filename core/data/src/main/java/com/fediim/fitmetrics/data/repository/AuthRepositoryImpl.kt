package com.fediim.fitmetrics.data.repository

import android.util.Log
import com.fediim.fitmetrics.api.apis.AuthorizationApi
import com.fediim.fitmetrics.api.infrastructure.HttpResponse
import com.fediim.fitmetrics.data.config.AuthConfig
import com.fediim.fitmetrics.data.local.TokenDataStore
import com.fediim.fitmetrics.data.mapper.FitBitAuthTokenMapper
import com.fediim.fitmetrics.data.model.FitBitAuthTokenDto
import com.fediim.fitmetrics.domain.model.FitBitAuthToken
import com.fediim.fitmetrics.domain.repository.FitBitAuthRepository
import io.ktor.http.ContentType
import io.ktor.util.reflect.typeInfo
import javax.inject.Inject
import kotlin.io.encoding.Base64

class AuthRepositoryImpl @Inject constructor(
    private val authorizationApi: AuthorizationApi,
    private val tokenDataStore: TokenDataStore,
    private val authConfig: AuthConfig,
    private val tokenMapper: FitBitAuthTokenMapper
) : FitBitAuthRepository {
    companion object {
        private const val TAG = "FitBitAuthRepository"
    }

    override suspend fun getStoredToken(): FitBitAuthToken? =
        try {
            tokenDataStore.getToken()
        } catch (e: Exception) {
            Log.e(TAG, "Error getting stored token", e)
            null
        }

    override suspend fun saveToken(token: FitBitAuthToken) {
        try {
            tokenDataStore.saveToken(token)
        } catch (e: Exception) {
            Log.e(TAG, "Error saving token", e)
        }
    }

    override suspend fun clearToken() {
        try {
            tokenDataStore.clearToken()
        } catch (e: Exception) {
            Log.e(TAG, "Error clearing token", e)
        }
    }

    override suspend fun exchangeCodeForToken(code: String): Result<FitBitAuthToken> =
        try {
            val basic = Base64.encode(
                "${authConfig.clientId}:${authConfig.clientSecret}".toByteArray()
            )
            val response: HttpResponse<Unit> =
                authorizationApi.oauthToken(
                    clientId = authConfig.clientId,
                    grantType = "authorization_code",
                    authorization = "Basic $basic",
                    contentType = with(
                        ContentType.Application.FormUrlEncoded
                    ) { "$contentType/$contentSubtype" },
                    code = code,
                    expiresIn = null,
                    redirectUri = authConfig.redirectUri,
                    refreshToken = null,
                    state = null
                )
            val tokenDto: FitBitAuthTokenDto = response.typedBody(
                typeInfo<FitBitAuthTokenDto>()
            )
            val domainToken = tokenMapper.mapToDomain(tokenDto)
            try {
                saveToken(domainToken)
            } catch (e: Exception) {
                Log.e(TAG, "Error saving token after exchange", e)
            }
            Result.success(domainToken)
        } catch (e: Exception) {
            Log.e(TAG, "Error exchanging code for token", e)
            Result.failure(e)
        }

    override suspend fun refreshToken(refreshToken: String): Result<FitBitAuthToken> =
        try {
            val basic = Base64.encode(
                "${'$'}{authConfig.clientId}:${'$'}{authConfig.clientSecret}".toByteArray()
            )
            val response: HttpResponse<Unit> =
                authorizationApi.oauthToken(
                    clientId = authConfig.clientId,
                    grantType = "refresh_token",
                    authorization = "Basic $basic",
                    contentType = with(
                        ContentType.Application.FormUrlEncoded
                    ) { "$contentType/$contentSubtype" },
                    code = null,
                    expiresIn = null,
                    redirectUri = null,
                    refreshToken = refreshToken,
                    state = null
                )
            val tokenDto: FitBitAuthTokenDto = response.typedBody(
                typeInfo<FitBitAuthTokenDto>()
            )
            val domainToken = tokenMapper.mapToDomain(tokenDto)
            try {
                saveToken(domainToken)
            } catch (e: Exception) {
                Log.e(TAG, "Error saving token after refresh", e)
            }
            Result.success(domainToken)
        } catch (e: Exception) {
            Log.e(TAG, "Error refreshing token", e)
            Result.failure(e)
        }
}
