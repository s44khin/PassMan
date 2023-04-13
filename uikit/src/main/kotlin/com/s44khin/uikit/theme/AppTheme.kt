package com.s44khin.uikit.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTheme(isDarkTheme: Boolean = isSystemInDarkTheme(), content: @Composable BoxScope.() -> Unit) {
    ProvideAppColors(colors = if (isDarkTheme) darkColors else lightColors) {
        MaterialTheme {
            Box(
                modifier = Modifier
                    .background(color = AppTheme.colors.background)
                    .fillMaxSize()
            ) {
                content()
            }
        }
    }
}

object AppTheme {

    val colors: AppColors
        @Composable
        get() = LocalAppColorsProvider.current

    val shapes: AppShapes
        get() = AppShapes
}
