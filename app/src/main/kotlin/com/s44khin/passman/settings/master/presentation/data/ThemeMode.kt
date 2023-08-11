package com.s44khin.passman.settings.master.presentation.data

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

enum class ThemeMode {
    System, Light, Dark;

    val isDarkTheme: Boolean
        @Composable
        get() = when (this) {
            System -> isSystemInDarkTheme()
            Light -> false
            Dark -> true
        }

    val isStatusBarDarkIcons: Boolean
        @Composable
        get() = when (this) {
            System -> !isSystemInDarkTheme()
            Light -> true
            Dark -> false
        }
}
