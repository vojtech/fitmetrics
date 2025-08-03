package com.fediim.ds.theme

import androidx.compose.ui.graphics.Color

sealed interface ColorAliases {

    val primary: Color
    val background: Color
    val onBackground: Color
    val surface: Color
    val onSurface: Color

    object Dark : ColorAliases {
        override val primary: Color = Color.White
        override val background = DarkColorTokens.background
        override val onBackground = DarkColorTokens.onBackground
        override val surface = DarkColorTokens.surface
        override val onSurface = DarkColorTokens.onSurface
    }

    object Light : ColorAliases {
        override val primary: Color = Color.Black
        override val background = LightColorTokens.background
        override val onBackground = LightColorTokens.onBackground
        override val surface = LightColorTokens.surface
        override val onSurface = LightColorTokens.onSurface
    }
}
