package com.fediim.fitmetrics.data.cache

import com.fediim.fitmetrics.domain.cache.CacheStrategy

/**
 * Configuration for the cache strategy
 */
class CacheConfig {
    /**
     * Maximum age of cache entries in milliseconds
     * Default: 1 hour
     */
    var defaultMaxAge: Long = 60 * 60 * 1000

    /**
     * Whether to clean up old cache entries automatically
     * Default: true
     */
    var autoCleanup: Boolean = true

    /**
     * Threshold for cleaning up old cache entries in milliseconds
     * Default: 24 hours
     */
    var cleanupThreshold: Long = 24 * 60 * 60 * 1000

    /**
     * Default cache policy
     * Default: CACHE_FIRST
     */
    var defaultPolicy: CacheStrategy.Policy = CacheStrategy.Policy.CACHE_FIRST
}
