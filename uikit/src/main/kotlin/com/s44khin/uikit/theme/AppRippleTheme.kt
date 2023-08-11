package com.s44khin.uikit.theme

import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable

class AppRippleTheme(private val colors: AppColors) : RippleTheme {

    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = colors.primary,
        lightTheme = !colors.isDark,
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = colors.primary,
        lightTheme = !colors.isDark,
    )
}
