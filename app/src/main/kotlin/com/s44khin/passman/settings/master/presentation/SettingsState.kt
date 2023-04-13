package com.s44khin.passman.settings.master.presentation

data class SettingsState(
    val showNextCode: Boolean = false,
    val showColor: Boolean = false,
    val buttonEnabled: Boolean = false,
) {

    fun changeShowNextCode() = copy(
        showNextCode = !showNextCode,
    )

    fun changeShowColor() = copy(
        showColor = !showColor
    )

    fun changeButtonEnabled(buttonEnabled: Boolean) = copy(
        buttonEnabled = buttonEnabled
    )
}
