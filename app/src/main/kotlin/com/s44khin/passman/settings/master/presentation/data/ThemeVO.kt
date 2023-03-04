package com.s44khin.passman.settings.master.presentation.data

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Smartphone
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import com.s44khin.passman.R

val themeList = listOf(ThemeVO.System, ThemeVO.Dark, ThemeVO.Light)

@Immutable
enum class ThemeVO {
    System, Dark, Light;

    @get:StringRes
    val label: Int
        get() = when (this) {
            System -> R.string.settings_theme_system
            Dark -> R.string.settings_theme_dark
            Light -> R.string.settings_theme_light
        }

    val icon: ImageVector
        get() = when (this) {
            System -> Icons.Outlined.Smartphone
            Dark -> Icons.Outlined.DarkMode
            Light -> Icons.Outlined.LightMode
        }
}