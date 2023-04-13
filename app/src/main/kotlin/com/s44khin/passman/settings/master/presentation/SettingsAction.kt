package com.s44khin.passman.settings.master.presentation

sealed class SettingsAction {

    object AddDebugData : SettingsAction()
    object ChangeShowNextCode : SettingsAction()
    object ChangeShowColor : SettingsAction()
    object DeleteAll : SettingsAction()
}
