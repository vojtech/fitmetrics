package com.fediim.fitmetrics

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

// FitBitApplication.kt
@HiltAndroidApp
class FitBitApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
