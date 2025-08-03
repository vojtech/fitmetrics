package com.fediim.fitmetrics.data.cache

import com.fediim.fitmetrics.data.local.dao.ActivityLogDao
import com.fediim.fitmetrics.data.local.dao.CacheMetadataDao
import com.fediim.fitmetrics.data.local.entity.CacheMetadataEntity
import com.fediim.fitmetrics.domain.cache.CacheStrategy
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Implementation of the CacheStrategy interface.
 * This class handles the caching logic based on the selected policy.
 */
@Singleton
class CacheStrategyImpl
@Inject
constructor(
    private val cacheMetadataDao: CacheMetadataDao,
    private val activityLogDao: ActivityLogDao,
    private val cacheConfig: CacheConfig
) : CacheStrategy {
    private var policy: CacheStrategy.Policy = cacheConfig.defaultPolicy

    override fun getPolicy(): CacheStrategy.Policy = policy

    override fun setPolicy(policy: CacheStrategy.Policy) {
        this.policy = policy
    }

    override suspend fun isCacheValid(
        key: String,
        maxAge: Long
    ): Boolean =
        withContext(Dispatchers.IO) {
            val metadata = cacheMetadataDao.getMetadata(key)
            if (metadata == null) {
                return@withContext false
            }

            val currentTime = System.currentTimeMillis()
            val cacheAge = currentTime - metadata.timestamp
            return@withContext cacheAge < maxAge
        }

    override suspend fun <T> execute(
        cacheKey: String,
        fetchFromCache: suspend () -> T?,
        fetchFromNetwork: suspend () -> T,
        saveToCache: suspend (T) -> Unit,
        maxAge: Long
    ): T {
        val effectiveMaxAge =
            if (maxAge ==
                CacheStrategy.DEFAULT_CACHE_MAX_AGE
            ) {
                cacheConfig.defaultMaxAge
            } else {
                maxAge
            }

        if (cacheConfig.autoCleanup) {
            cleanupOldCacheEntries()
        }

        return when (policy) {
            CacheStrategy.Policy.NETWORK_ONLY -> {
                fetchFromNetworkAndCache(cacheKey, fetchFromNetwork, saveToCache)
            }

            CacheStrategy.Policy.CACHE_FIRST -> {
                fetchWithCacheFirst(
                    cacheKey,
                    fetchFromCache,
                    fetchFromNetwork,
                    saveToCache,
                    effectiveMaxAge
                )
            }

            CacheStrategy.Policy.CACHE_ONLY -> {
                fetchFromCacheOnly(fetchFromCache)
            }
        }
    }

    private suspend fun <T> fetchFromNetworkAndCache(
        cacheKey: String,
        fetchFromNetwork: suspend () -> T,
        saveToCache: suspend (T) -> Unit
    ): T =
        try {
            val networkData = fetchFromNetwork()
            try {
                saveToCache(networkData)
                updateCacheMetadata(cacheKey)
            } catch (e: Exception) {
                Timber.e(e, "Error saving data to cache")
            }
            networkData
        } catch (e: Exception) {
            Timber.e(e, "Error fetching data from network")
            throw e
        }

    private suspend fun <T> fetchWithCacheFirst(
        cacheKey: String,
        fetchFromCache: suspend () -> T?,
        fetchFromNetwork: suspend () -> T,
        saveToCache: suspend (T) -> Unit,
        maxAge: Long
    ): T {
        // Try to get from cache first
        val cacheData = fetchFromCache()

        // If cache data exists and is valid, return it
        if (cacheData != null && isCacheValid(cacheKey, maxAge)) {
            return cacheData
        }

        // Otherwise fetch from network; if it fails and we have stale cache, fallback to it
        return try {
            fetchFromNetworkAndCache(cacheKey, fetchFromNetwork, saveToCache)
        } catch (e: Exception) {
            if (cacheData != null) {
                Timber.w(e, "Network fetch failed; returning stale cache for key=$cacheKey")
                cacheData
            } else {
                throw e
            }
        }
    }

    private suspend fun <T> fetchFromCacheOnly(fetchFromCache: suspend () -> T?): T =
        fetchFromCache() ?: throw CacheOnlyException("No data available in cache")

    private suspend fun updateCacheMetadata(key: String) {
        val metadata =
            CacheMetadataEntity(
                key = key,
                timestamp = System.currentTimeMillis()
            )
        cacheMetadataDao.insertOrUpdate(metadata)
    }

    /**
     * Cleans up old cache entries based on the cleanup threshold from config
     */
    private suspend fun cleanupOldCacheEntries() {
        try {
            val threshold = System.currentTimeMillis() - cacheConfig.cleanupThreshold
            val deletedMeta = cacheMetadataDao.deleteOlderThan(threshold)
            val deletedLogs = activityLogDao.deleteOlderThan(threshold)
            if (deletedMeta > 0 || deletedLogs > 0) {
                Timber.d(
                    "Cleaned up old cache entries: metadata=$deletedMeta, logs=$deletedLogs"
                )
            }
        } catch (e: Exception) {
            Timber.e(e, "Error cleaning up old cache entries")
        }
    }

    class CacheOnlyException(
        message: String
    ) : Exception(message)
}
