package com.s44khin.passman.settings.master.presentation

import com.s44khin.uikit.theme.PrimaryColor

sealed class SettingsAction {

    data class ChangeColor(val newColor: PrimaryColor) : SettingsAction()
    object AddDebugData : SettingsAction()
    object ChangeShowAccount : SettingsAction()
    object ChangeShowColor : SettingsAction()
    object ChangeShowLabel : SettingsAction()
    object ChangeShowNextCode : SettingsAction()
    object DeleteAll : SettingsAction()
    object OnDarkThemeClick : SettingsAction()
    object OnLightThemeClick : SettingsAction()
    object OnSystemThemeClick : SettingsAction()
}
