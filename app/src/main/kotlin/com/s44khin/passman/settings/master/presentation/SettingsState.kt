package com.s44khin.passman.settings.master.presentation

import com.s44khin.passman.settings.master.presentation.data.ThemeVO

data class SettingsState(
    val currentTheme: ThemeVO = ThemeVO.System,
    val showNextCode: Boolean = false,
    val buttonEnabled: Boolean = false,
) {

    fun changeTheme(newTheme: ThemeVO) = copy(currentTheme = newTheme)

    fun changeShowNextCode() = copy(
        showNextCode = !showNextCode,
    )

    fun changeButtonEnabled(buttonEnabled: Boolean) = copy(
        buttonEnabled = buttonEnabled
    )
}
