package com.fediim.fitmetrics.domain.cache

/**
 * Interface defining a generic caching strategy.
 * This strategy determines how data is fetched, either from cache or from network,
 * and how it is stored in the cache.
 */
interface CacheStrategy {
    /**
     * Enum defining different cache policies
     */
    enum class Policy {
        /**
         * Always fetch from network, ignore cache
         */
        NETWORK_ONLY,

        /**
         * Try to fetch from cache first, if not available or expired, fetch from network
         */
        CACHE_FIRST,

        /**
         * Always fetch from cache, never from network
         */
        CACHE_ONLY
    }

    /**
     * Get the current cache policy
     */
    fun getPolicy(): Policy

    /**
     * Set the cache policy
     * @param policy The cache policy to set
     */
    fun setPolicy(policy: Policy)

    /**
     * Check if data in cache is valid (not expired)
     * @param key The cache key
     * @param maxAge Maximum age of cached data in milliseconds
     * @return true if cache is valid, false otherwise
     */
    suspend fun isCacheValid(
        key: String,
        maxAge: Long
    ): Boolean

    /**
     * Generic function to execute a caching strategy
     * @param cacheKey The key to identify the cached data
     * @param fetchFromCache Function to fetch data from cache
     * @param fetchFromNetwork Function to fetch data from network
     * @param saveToCache Function to save data to cache
     * @param maxAge Maximum age of cached data in milliseconds
     * @return The data, either from cache or network
     */
    suspend fun <T> execute(
        cacheKey: String,
        fetchFromCache: suspend () -> T?,
        fetchFromNetwork: suspend () -> T,
        saveToCache: suspend (T) -> Unit,
        maxAge: Long = DEFAULT_CACHE_MAX_AGE
    ): T

    companion object {
        /**
         * Default maximum age for cached data (24 hours)
         */
        const val DEFAULT_CACHE_MAX_AGE = 24 * 60 * 60 * 1000L // 24 hours in milliseconds
    }
}
