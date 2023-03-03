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
    rootBackground: Color,
    background: Color,
) {
    var rootBackground by mutableStateOf(rootBackground)
        private set

    var background by mutableStateOf(background)
        private set

    internal fun copy() = AppColors(
        rootBackground = rootBackground,
        background = background,
    )

    internal fun update(other: AppColors) {
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
        rootBackground = Color(0xffedeef0),
        background = Color(0xffffffff)
    )

internal val darkColors: AppColors
    @Composable
    get() = AppColors(
        rootBackground = Color(0xff141414),
        background = Color(0xff222222)
    )
