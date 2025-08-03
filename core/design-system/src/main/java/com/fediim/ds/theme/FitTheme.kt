package com.fediim.ds.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun FitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        !disableDynamicTheming && supportsDynamicTheming() -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        else -> getColorScheme(if (darkTheme) ColorAliases.Dark else ColorAliases.Light)
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

fun getColorScheme(aliases: ColorAliases): ColorScheme {
    val primary = aliases.primary
    val background = aliases.background
    val onBackground = aliases.onBackground
    val surface = aliases.surface
    val onSurface = aliases.onSurface
    return when (aliases) {
        is ColorAliases.Light -> lightColorScheme(
            primary = primary,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface
        )

        is ColorAliases.Dark -> darkColorScheme(
            primary = primary,
            background = background,
            onBackground = onBackground,
            surface = surface,
            onSurface = onSurface
        )
    }
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
