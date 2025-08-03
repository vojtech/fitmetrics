package com.fediim.fitmetrics.data.repository

import com.fediim.fitmetrics.data.local.dao.ActivityLogDao
import com.fediim.fitmetrics.data.mapper.ActivityLogEntityMapper
import com.fediim.fitmetrics.data.mapper.ActivityLogMapper
import com.fediim.fitmetrics.data.remote.FitBitActivityApi
import com.fediim.fitmetrics.domain.cache.CacheStrategy
import com.fediim.fitmetrics.domain.model.ActivityLogDetail
import com.fediim.fitmetrics.domain.model.ActivityLogFilter
import com.fediim.fitmetrics.domain.model.ActivityType
import com.fediim.fitmetrics.domain.model.PaginatedActivityLogs
import com.fediim.fitmetrics.domain.model.Pagination
import com.fediim.fitmetrics.domain.repository.ActivityLogRepository
import com.fediim.fitmetrics.domain.repository.FitBitAuthRepository
import java.time.LocalDate
import javax.inject.Inject
import timber.log.Timber

class ActivityLogRepositoryImpl @Inject constructor(
    private val api: FitBitActivityApi,
    private val authRepository: FitBitAuthRepository,
    private val mapper: ActivityLogMapper,
    private val entityMapper: ActivityLogEntityMapper,
    private val activityLogDao: ActivityLogDao,
    private val cacheStrategy: CacheStrategy
) : ActivityLogRepository {
    companion object {
        private val ALL_ACTIVITY_TYPE = ActivityType(0, "All")
    }

    override suspend fun getActivityLogs(
        filter: ActivityLogFilter?,
        offset: Int,
        limit: Int
    ): Result<PaginatedActivityLogs> {
        val cacheKey = buildCacheKey("activity_logs", filter, offset, limit)

        return try {
            Result.success(
                cacheStrategy.execute(
                    cacheKey = cacheKey,
                    fetchFromCache = {
                        val startDateStr = filter?.startDate?.toString()
                        val endDateStr = filter?.endDate?.toString()
                        val activityTypeId = filter?.activityType

                        val cachedLogs =
                            activityLogDao.getActivityLogs(
                                startDate = startDateStr,
                                endDate = endDateStr,
                                activityTypeId = activityTypeId,
                                limit = limit,
                                offset = offset
                            )

                        if (cachedLogs.isEmpty()) {
                            null
                        } else {
                            val activities = cachedLogs.map {
                                entityMapper.toActivityLogListItem(
                                    it
                                )
                            }

                            val pagination =
                                Pagination(
                                    beforeDate = filter?.endDate,
                                    afterDate = filter?.startDate,
                                    limit = limit,
                                    offset = offset,
                                    hasNext = cachedLogs.size >= limit,
                                    hasPrevious = offset > 0,
                                    sort = "desc"
                                )

                            PaginatedActivityLogs(activities, pagination)
                        }
                    },
                    fetchFromNetwork = {
                        val token =
                            authRepository.getStoredToken()
                                ?: throw IllegalStateException(
                                    "No authentication token available"
                                )

                        if (token.isExpired()) {
                            val refreshResult = authRepository.refreshToken(token.refreshToken)
                            if (refreshResult.isFailure) {
                                throw refreshResult.exceptionOrNull() ?: Exception(
                                    "Failed to refresh token"
                                )
                            }
                        }

                        val beforeDate = filter?.endDate ?: if (filter?.startDate == null) LocalDate.now() else null
                        val afterDate = if (beforeDate == null) filter?.startDate else null

                        val response =
                            api
                                .getActivityLogs(
                                    accessToken = token.accessToken,
                                    beforeDate = beforeDate,
                                    afterDate = afterDate,
                                    offset = offset,
                                    limit = limit
                                ).getOrThrow()

                        var activities = mapper.mapListResponseToDomain(response)

                        filter?.activityType?.let { activityTypeId ->
                            if (activityTypeId > 0) {
                                activities = activities.filter { it.activityTypeId == activityTypeId }
                            }
                        }

                        val pagination =
                            Pagination(
                                beforeDate = beforeDate,
                                afterDate = afterDate,
                                limit = response.pagination.limit,
                                offset = response.pagination.offset,
                                hasNext = response.pagination.next != null,
                                hasPrevious = response.pagination.previous != null,
                                sort = response.pagination.sort
                            )

                        PaginatedActivityLogs(activities, pagination)
                    },
                    saveToCache = { paginatedLogs ->

                        val entities = paginatedLogs.activities.map {
                            entityMapper.toEntity(
                                it
                            )
                        }
                        activityLogDao.insertOrUpdateActivityLogs(*entities.toTypedArray())
                    }
                )
            )
        } catch (e: Exception) {
            Timber.e(e, "Error getting activity logs")
            Result.failure(e)
        }
    }

    /**
     * Build a cache key based on the request parameters
     */
    private fun buildCacheKey(
        prefix: String,
        filter: ActivityLogFilter?,
        offset: Int,
        limit: Int
    ): String {
        val startDate = filter?.startDate?.toString() ?: "null"
        val endDate = filter?.endDate?.toString() ?: "null"
        val activityType = filter?.activityType?.toString() ?: "null"
        return "$prefix-$startDate-$endDate-$activityType-$offset-$limit"
    }

    override suspend fun getActivityLogById(logId: Long): Result<ActivityLogDetail> {
        val cacheKey = "activity_log_detail-$logId"

        return try {
            Result.success(
                cacheStrategy.execute(
                    cacheKey = cacheKey,
                    fetchFromCache = {
                        val cachedLog = activityLogDao.getActivityLogById(logId)

                        if (cachedLog != null && cachedLog.cacheType == "DETAIL") {
                            entityMapper.toActivityLogDetail(cachedLog)
                        } else {
                            null
                        }
                    },
                    fetchFromNetwork = {
                        val token =
                            authRepository.getStoredToken()
                                ?: throw IllegalStateException(
                                    "No authentication token available"
                                )

                        if (token.isExpired()) {
                            val refreshResult = authRepository.refreshToken(token.refreshToken)
                            if (refreshResult.isFailure) {
                                throw refreshResult.exceptionOrNull() ?: Exception(
                                    "Failed to refresh token"
                                )
                            }
                        }

                        val response =
                            api
                                .getActivityLogById(
                                    accessToken = token.accessToken,
                                    logId = logId
                                ).getOrThrow()

                        mapper.mapDetailToDomain(response)
                    },
                    saveToCache = { activityLogDetail ->

                        val entity = entityMapper.toEntity(activityLogDetail)
                        activityLogDao.insertOrUpdateActivityLogs(entity)
                    }
                )
            )
        } catch (e: Exception) {
            Timber.e(e, "Error getting activity log by id: $logId")
            Result.failure(e)
        }
    }

    override suspend fun getActivityTypes(): Result<List<ActivityType>> =
        try {
            val paginatedLogs = getActivityLogs(offset = 0, limit = 50)

            paginatedLogs.fold(
                onSuccess = { logs ->

                    val activityTypes =
                        logs.activities
                            .filter { it.activityTypeId > 0 }
                            .map { ActivityType(it.activityTypeId, it.activityName) }
                            .distinctBy { it.id }
                            .sortedBy { it.name }

                    Result.success(listOf(ALL_ACTIVITY_TYPE) + activityTypes)
                },
                onFailure = { error ->

                    Result.success(listOf(ALL_ACTIVITY_TYPE))
                }
            )
        } catch (e: Exception) {
            Timber.e(e, "Error getting activity types")

            Result.success(listOf(ALL_ACTIVITY_TYPE))
        }
}
