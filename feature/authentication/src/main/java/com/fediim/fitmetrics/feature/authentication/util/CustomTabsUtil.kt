package com.fediim.fitmetrics.feature.authentication.util

import android.content.Context
import android.content.Intent
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri

fun launchCustomTab(
    context: Context,
    url: String
) {
    val customTabsIntent =
        CustomTabsIntent
            .Builder()
            .setShowTitle(true)
            .setInstantAppsEnabled(false)
            .build()

    customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
    customTabsIntent.launchUrl(context, url.toUri())
}
