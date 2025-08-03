package com.fediim.fitmetrics.data.di

import android.content.Context
import androidx.room.Room
import com.fediim.fitmetrics.data.cache.CacheConfig
import com.fediim.fitmetrics.data.cache.CacheStrategyImpl
import com.fediim.fitmetrics.data.local.AppDatabase
import com.fediim.fitmetrics.data.local.dao.ActivityLogDao
import com.fediim.fitmetrics.data.local.dao.CacheMetadataDao
import com.fediim.fitmetrics.data.mapper.ActivityLogEntityMapper
import com.fediim.fitmetrics.data.mapper.ActivityLogMapper
import com.fediim.fitmetrics.data.mapper.FitBitAuthTokenMapper
import com.fediim.fitmetrics.data.provider.AuthUrlProviderImpl
import com.fediim.fitmetrics.data.remote.FitBitProfileApi
import com.fediim.fitmetrics.data.repository.ActivityLogRepositoryImpl
import com.fediim.fitmetrics.data.repository.AuthRepositoryImpl
import com.fediim.fitmetrics.data.repository.ProfileRepositoryImpl
import com.fediim.fitmetrics.domain.cache.CacheStrategy
import com.fediim.fitmetrics.domain.repository.ActivityLogRepository
import com.fediim.fitmetrics.domain.repository.FitBitAuthRepository
import com.fediim.fitmetrics.domain.repository.ProfileRepository
import com.fediim.fitmetrics.domain.usecase.AuthUrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideHttpClient(): HttpClient =
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        explicitNulls = false
                    }
                )
            }

            install(Logging) {
                logger =
                    object : Logger {
                        override fun log(message: String) {
                            Timber.d(message)
                        }
                    }
                level = LogLevel.ALL
            }
        }

    @Provides
    fun provideFitBitAuthRepository(impl: AuthRepositoryImpl): FitBitAuthRepository = impl

    @Provides
    fun provideAuthUrlProvider(impl: AuthUrlProviderImpl): AuthUrlProvider = impl

    @Provides
    fun provideFitBitAuthTokenMapper(): FitBitAuthTokenMapper = FitBitAuthTokenMapper()

    @Provides
    fun provideActivityLogMapper(): ActivityLogMapper = ActivityLogMapper()

    @Provides
    fun provideActivityLogEntityMapper(): ActivityLogEntityMapper = ActivityLogEntityMapper()

    @Provides
    fun provideActivityLogRepository(impl: ActivityLogRepositoryImpl): ActivityLogRepository = impl

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                "fitbit_analyser.db"
            ).fallbackToDestructiveMigration(true)
            .build()

    @Provides
    fun provideCacheMetadataDao(
        database: AppDatabase
    ): CacheMetadataDao = database.cacheMetadataDao()

    @Provides
    fun provideActivityLogDao(database: AppDatabase): ActivityLogDao = database.activityLogDao()

    @Provides
    fun provideUserProfileDao(
        database: AppDatabase
    ): com.fediim.fitmetrics.data.local.dao.UserProfileDao = database.userProfileDao()

    @Provides
    fun provideBadgeDao(
        database: AppDatabase
    ): com.fediim.fitmetrics.data.local.dao.BadgeDao = database.badgeDao()

    @Singleton
    @Provides
    fun provideCacheConfig(): CacheConfig = CacheConfig()

    @Singleton
    @Provides
    fun provideCacheStrategy(impl: CacheStrategyImpl): CacheStrategy = impl

    @Provides
    fun provideActivityApi(): com.fediim.fitmetrics.api.apis.ActivityApi =
        com.fediim.fitmetrics.api.apis.ActivityApi(
            httpClientConfig = { cfg ->
                cfg.install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            explicitNulls = false
                        }
                    )
                }
            }
        )

    @Provides
    fun provideUserApi(): com.fediim.fitmetrics.api.apis.UserApi =
        com.fediim.fitmetrics.api.apis.UserApi(
            httpClientConfig = { cfg ->
                cfg.install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            explicitNulls = false
                        }
                    )
                }
            }
        )

    @Provides
    fun provideAuthorizationApi(): com.fediim.fitmetrics.api.apis.AuthorizationApi =
        com.fediim.fitmetrics.api.apis.AuthorizationApi(
            httpClientConfig = { cfg ->
                cfg.install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            explicitNulls = false
                        }
                    )
                }
            }
        )

    @Provides
    fun provideFitBitProfileApi(
        userApi: com.fediim.fitmetrics.api.apis.UserApi
    ): FitBitProfileApi = FitBitProfileApi(userApi)

    @Provides
    fun provideProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository = impl
}
