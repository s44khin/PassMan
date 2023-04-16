package com.s44khin.passman.settings.master.presentation

data class SettingsState(
    val showNextCode: Boolean = false,
    val showColor: Boolean = false,
    val alwaysShowLabel: Boolean = false,
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
}
