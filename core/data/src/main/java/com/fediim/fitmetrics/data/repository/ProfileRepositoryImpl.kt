package com.fediim.fitmetrics.data.repository

import com.fediim.fitmetrics.data.local.dao.BadgeDao
import com.fediim.fitmetrics.data.local.dao.UserProfileDao
import com.fediim.fitmetrics.data.local.entity.BadgeEntity
import com.fediim.fitmetrics.data.local.entity.UserProfileEntity
import com.fediim.fitmetrics.data.remote.FitBitProfileApi
import com.fediim.fitmetrics.domain.model.Badge
import com.fediim.fitmetrics.domain.model.UserProfile
import com.fediim.fitmetrics.domain.repository.FitBitAuthRepository
import com.fediim.fitmetrics.domain.repository.ProfileRepository
import javax.inject.Inject
import timber.log.Timber

class ProfileRepositoryImpl @Inject constructor(
    private val profileApi: FitBitProfileApi,
    private val authRepository: FitBitAuthRepository,
    private val userProfileDao: UserProfileDao,
    private val badgeDao: BadgeDao
) : ProfileRepository {
    override suspend fun getUserProfile(forceRefresh: Boolean): Result<UserProfile> {
        return try {
            val now = System.currentTimeMillis()
            val cached = userProfileDao.getProfile()
            if (cached != null && !forceRefresh && now - cached.cacheTimestamp < 24 * 60 * 60 * 1000L) {
                return Result.success(cached.toDomain())
            }

            val token =
                authRepository.getStoredToken() ?: throw IllegalStateException(
                    "No authentication token available"
                )
            val validToken =
                if (token.isExpired()) {
                    authRepository.refreshToken(token.refreshToken).getOrElse { throw it }
                } else {
                    token
                }

            val dto = profileApi.getUserProfile(validToken.accessToken).getOrThrow()
            val user = dto.user
            val entity =
                UserProfileEntity(
                    encodedId = user.encodedId,
                    displayName = user.displayName,
                    avatar = user.avatar,
                    avatar150 = user.avatar150,
                    avatar640 = user.avatar640,
                    age = user.age,
                    gender = user.gender,
                    distanceUnit = user.distanceUnit,
                    heightUnit = user.heightUnit,
                    weightUnit = user.weightUnit,
                    temperatureUnit = user.temperatureUnit,
                    swimUnit = user.swimUnit,
                    waterUnitName = user.waterUnitName,
                    timezone = user.timezone,
                    locale = user.locale,
                    cacheTimestamp = now
                )
            userProfileDao.insertOrUpdate(entity)
            Result.success(entity.toDomain())
        } catch (e: Exception) {
            Timber.e(e, "Error getting profile")
            // Fallback to cache
            val cached = userProfileDao.getProfile()
            if (cached != null) Result.success(cached.toDomain()) else Result.failure(e)
        }
    }

    override suspend fun getUserBadges(forceRefresh: Boolean): Result<List<Badge>> {
        return try {
            val now = System.currentTimeMillis()
            val cached = badgeDao.getBadges()
            if (cached.isNotEmpty() && !forceRefresh) {
                return Result.success(cached.map { it.toDomain() })
            }

            val token =
                authRepository.getStoredToken() ?: throw IllegalStateException(
                    "No authentication token available"
                )
            val validToken =
                if (token.isExpired()) {
                    authRepository.refreshToken(token.refreshToken).getOrElse { throw it }
                } else {
                    token
                }

            val dto = profileApi.getUserBadges(validToken.accessToken).getOrThrow()
            badgeDao.clear()
            val entities =
                dto.badges.map { b ->
                    BadgeEntity(
                        badgeType = b.badgeType,
                        name = b.name,
                        description = b.description,
                        imageUrl = b.image100px,
                        cacheTimestamp = now
                    )
                }
            badgeDao.insertAll(entities)
            Result.success(entities.map { it.toDomain() })
        } catch (e: Exception) {
            Timber.e(e, "Error getting badges")
            val cached = badgeDao.getBadges()
            if (cached.isNotEmpty()) {
                Result.success(
                    cached.map { it.toDomain() }
                )
            } else {
                Result.failure(e)
            }
        }
    }
}

private fun UserProfileEntity.toDomain(): UserProfile =
    UserProfile(
        encodedId = encodedId,
        displayName = displayName,
        avatar = avatar,
        avatar150 = avatar150,
        avatar640 = avatar640,
        age = age,
        gender = gender,
        distanceUnit = distanceUnit,
        heightUnit = heightUnit,
        weightUnit = weightUnit,
        temperatureUnit = temperatureUnit,
        swimUnit = swimUnit,
        waterUnitName = waterUnitName,
        timezone = timezone,
        locale = locale
    )

private fun BadgeEntity.toDomain(): Badge =
    Badge(
        badgeType = badgeType,
        name = name,
        description = description,
        imageUrl = imageUrl
    )
