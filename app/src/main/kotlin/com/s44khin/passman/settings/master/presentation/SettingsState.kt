package com.s44khin.passman.settings.master.presentation

import com.s44khin.passman.settings.master.presentation.data.ThemeVO

data class SettingsState(
    val currentTheme: ThemeVO = ThemeVO.System,
) {

    fun changeTheme(newTheme: ThemeVO) = copy(currentTheme = newTheme)
}
