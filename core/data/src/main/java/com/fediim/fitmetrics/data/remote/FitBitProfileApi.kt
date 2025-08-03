package com.fediim.fitmetrics.data.remote

import com.fediim.fitmetrics.api.apis.UserApi
import com.fediim.fitmetrics.data.model.BadgesResponseDto
import com.fediim.fitmetrics.data.model.UserProfileResponseDto
import io.ktor.util.reflect.typeInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FitBitProfileApi @Inject constructor(
    private val userApi: UserApi
) {
    suspend fun getUserProfile(accessToken: String): Result<UserProfileResponseDto> =
        runCatching {
            userApi.setAccessToken(accessToken)
            val response = userApi.getProfile()
            response.typedBody(typeInfo<UserProfileResponseDto>())
        }

    suspend fun getUserBadges(accessToken: String): Result<BadgesResponseDto> =
        runCatching {
            userApi.setAccessToken(accessToken)
            val response = userApi.getBadges()
            response.typedBody(typeInfo<BadgesResponseDto>())
        }
}
