package com.s44khin.uikit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(isDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    ProvideAppColors(colors = if (isDarkTheme) darkColors else lightColors) {
        MaterialTheme {
            content()
        }
    }
}

object AppTheme {

    val colors: AppColors
        @Composable
        get() = LocalAppColorsProvider.current
}