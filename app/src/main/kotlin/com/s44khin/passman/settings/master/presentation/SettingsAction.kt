package com.s44khin.passman.settings.master.presentation

import com.s44khin.passman.settings.master.presentation.data.ThemeVO

sealed class SettingsAction {

    data class ChangeTheme(val theme: ThemeVO) : SettingsAction()
    object AddDebugData : SettingsAction()
    object ChangeShowNextCode : SettingsAction()
    object DeleteAll : SettingsAction()
    object Restart : SettingsAction()
}
