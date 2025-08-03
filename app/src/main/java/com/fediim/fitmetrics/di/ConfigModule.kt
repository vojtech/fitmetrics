package com.fediim.fitmetrics.di

import com.fediim.fitmetrics.BuildConfig
import com.fediim.fitmetrics.data.config.AuthConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ConfigModule {
    @Provides
    fun provideAuthConfig(): AuthConfig =
        AuthConfig(
            clientId = BuildConfig.FITBIT_CLIENT_ID,
            clientSecret = BuildConfig.FITBIT_CLIENT_SECRET,
            redirectUri = BuildConfig.FITBIT_REDIRECT_URI
        )
}
