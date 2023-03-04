package com.s44khin.uikit.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
open class AppColors internal constructor(
    primary: Color,
    rootBackground: Color,
    background: Color,
) {
    var primary by mutableStateOf(primary)
        private set

    var rootBackground by mutableStateOf(rootBackground)
        private set

    var background by mutableStateOf(background)
        private set

    internal fun copy() = AppColors(
        primary = primary,
        rootBackground = rootBackground,
        background = background,
    )

    internal fun update(other: AppColors) {
        primary = other.primary
        rootBackground = other.rootBackground
        background = other.background
    }
}

internal val LocalAppColorsProvider = staticCompositionLocalOf<AppColors> {
    error("No Color provided")
}

@Composable
internal fun ProvideAppColors(
    colors: AppColors,
    content: @Composable () -> Unit
) {
    val newColors = remember {
        colors.copy()
    }

    newColors.update(colors)

    CompositionLocalProvider(LocalAppColorsProvider provides newColors, content = content)
}

internal val lightColors: AppColors
    @Composable
    get() = AppColors(
        primary = Color(0xffe65100),
        rootBackground = Color(0xffedeef0),
        background = Color(0xffffffff)
    )

internal val darkColors: AppColors
    @Composable
    get() = AppColors(
        primary = Color(0xffe65100),
        rootBackground = Color(0xff141414),
        background = Color(0xff222222)
    )
