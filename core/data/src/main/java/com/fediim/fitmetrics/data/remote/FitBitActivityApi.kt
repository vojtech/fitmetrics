package com.fediim.fitmetrics.data.remote

import com.fediim.fitmetrics.api.apis.ActivityApi
import com.fediim.fitmetrics.api.infrastructure.HttpResponse
import com.fediim.fitmetrics.data.model.ActivityLogDetailDto
import com.fediim.fitmetrics.data.model.ActivityLogDetailResponseDto
import com.fediim.fitmetrics.data.model.ActivityLogListResponseDto
import io.ktor.util.reflect.typeInfo
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FitBitActivityApi @Inject constructor(
    private val activityApi: ActivityApi
) {
    suspend fun getActivityLogs(
        accessToken: String,
        beforeDate: LocalDate? = null,
        afterDate: LocalDate? = null,
        limit: Int = 20,
        offset: Int = 0,
        sort: String = "desc"
    ): Result<ActivityLogListResponseDto> =
        runCatching {
            activityApi.setAccessToken(accessToken)

            val response: HttpResponse<Unit> =
                activityApi.getActivitiesLogList(
                    sort = sort,
                    offset = offset,
                    limit = limit,
                    beforeDate = beforeDate,
                    afterDate = afterDate
                )

            response.typedBody(typeInfo<ActivityLogListResponseDto>())
        }

    suspend fun getActivityLogById(
        accessToken: String,
        logId: Long
    ): Result<ActivityLogDetailDto> =
        runCatching {
            activityApi.setAccessToken(accessToken)
            val response: HttpResponse<Unit> = activityApi.getActivitiesTypeDetail(
                logId.toString()
            )
            val detailResponse: ActivityLogDetailResponseDto = response.typedBody(
                typeInfo<ActivityLogDetailResponseDto>()
            )
            detailResponse.activityLog
        }
}
