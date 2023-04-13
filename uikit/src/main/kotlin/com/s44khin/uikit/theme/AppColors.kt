package com.s44khin.uikit.theme

import androidx.compose.material.MaterialTheme
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
    background: Color,
    borderOnBackground: Color,
    textOnPrimary: Color,
    textOnBackground: Color,
    textOnBackgroundVariant: Color,
    textBoxBackground: Color,
    divider: Color,
) {
    var primary by mutableStateOf(primary)
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

    var textBoxBackground by mutableStateOf(textBoxBackground)
        private set

    var divider by mutableStateOf(divider)
        private set

    internal fun copy() = AppColors(
        primary = primary,
        background = background,
        borderOnBackground = borderOnBackground,
        textOnPrimary = textOnPrimary,
        textOnBackground = textOnBackground,
        textOnBackgroundVariant = textOnBackgroundVariant,
        textBoxBackground = textBoxBackground,
        divider = divider,
    )

    internal fun update(other: AppColors) {
        primary = other.primary
        background = other.background
        borderOnBackground = other.borderOnBackground
        textOnPrimary = other.textOnPrimary
        textOnBackground = other.textOnBackground
        textOnBackgroundVariant = other.textOnBackgroundVariant
        textBoxBackground = other.textBoxBackground
        divider = other.divider
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
        background = Color(0xffffffff),
        borderOnBackground = Color(0x40000000),
        textOnPrimary = Color(0xFFFFFFFF),
        textOnBackground = Color(0xff000000),
        textOnBackgroundVariant = Color(0x80000000),
        textBoxBackground = Color(0xffedeef0),
        divider = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
    )

internal val darkColors: AppColors
    @Composable
    get() = AppColors(
        primary = Color(0xffe65100),
        background = Color(0xff222222),
        borderOnBackground = Color(0x40FFFFFF),
        textOnPrimary = Color(0xFFFFFFFF),
        textOnBackground = Color(0xffffffff),
        textOnBackgroundVariant = Color(0x80FFFFFF),
        textBoxBackground = Color(0xff141414),
        divider = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
    )
