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
    borderOnBackground: Color,
    textOnPrimary: Color,
    textOnBackground: Color,
    textOnBackgroundVariant: Color,
) {
    var primary by mutableStateOf(primary)
        private set

    var rootBackground by mutableStateOf(rootBackground)
        private set

    var background by mutableStateOf(background)
        private set

    var borderOnBackground by mutableStateOf(borderOnBackground)
        private set

    var textOnPrimary by mutableStateOf(textOnPrimary)
        private set

    var textOnBackground by mutableStateOf(textOnBackground)
        private set

    var textOnBackgroundVariant by mutableStateOf(textOnBackgroundVariant)
        private set

    internal fun copy() = AppColors(
        primary = primary,
        rootBackground = rootBackground,
        background = background,
        borderOnBackground = borderOnBackground,
        textOnPrimary = textOnPrimary,
        textOnBackground = textOnBackground,
        textOnBackgroundVariant = textOnBackgroundVariant,
    )

    internal fun update(other: AppColors) {
        primary = other.primary
        rootBackground = other.rootBackground
        background = other.background
        borderOnBackground = other.borderOnBackground
        textOnPrimary = other.textOnPrimary
        textOnBackground = other.textOnBackground
        textOnBackgroundVariant = other.textOnBackgroundVariant
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
        background = Color(0xffffffff),
        borderOnBackground = Color(0x40000000),
        textOnPrimary = Color(0xff000000),
        textOnBackground = Color(0xff000000),
        textOnBackgroundVariant = Color(0xB3000000),
    )

internal val darkColors: AppColors
    @Composable
    get() = AppColors(
        primary = Color(0xffe65100),
        rootBackground = Color(0xff141414),
        background = Color(0xff222222),
        borderOnBackground = Color(0x40FFFFFF),
        textOnPrimary = Color(0xff000000),
        textOnBackground = Color(0xffffffff),
        textOnBackgroundVariant = Color(0xB3FFFFFF),
    )
