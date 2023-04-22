package com.s44khin.passman.settings.master.presentation

import com.s44khin.passman.settings.master.presentation.data.ThemeMode
import com.s44khin.uikit.theme.PrimaryColor

data class SettingsState(
    val showNextCode: Boolean = false,
    val showColor: Boolean = false,
    val alwaysShowLabel: Boolean = false,
    val showAccount: Boolean = true,
    val themeMode: ThemeMode = ThemeMode.System,
    val color: PrimaryColor = PrimaryColor.ORANGE,
) {

    fun changeShowNextCode() = copy(
        showNextCode = !showNextCode,
    )

    fun changeShowColor() = copy(
        showColor = !showColor
    )

    fun changeShowLabel() = copy(
        alwaysShowLabel = !alwaysShowLabel
    )

    fun changeShowAccount() = copy(
        showAccount = !showAccount
    )

    fun toSystemTheme() = copy(
        themeMode = ThemeMode.System
    )

    fun toLightTheme() = copy(
        themeMode = ThemeMode.Light,
    )

    fun toDarkTheme() = copy(
        themeMode = ThemeMode.Dark,
    )

    fun toNewColor(newColor: PrimaryColor) = copy(
        color = newColor,
    )
}
