package com.s44khin.passman.settings.master.presentation

import com.s44khin.passman.settings.master.presentation.data.ThemeMode

data class SettingsState(
    val showNextCode: Boolean = false,
    val showColor: Boolean = false,
    val alwaysShowLabel: Boolean = false,
    val showAccount: Boolean = true,
    val themeMode: ThemeMode = ThemeMode.System,
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
}
