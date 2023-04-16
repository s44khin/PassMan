package com.s44khin.passman.core

import com.s44khin.passman.settings.master.presentation.data.ThemeMode

data class MainState(
    val alwaysShowLabel: Boolean = false,
    val theme: ThemeMode = ThemeMode.System,
)
