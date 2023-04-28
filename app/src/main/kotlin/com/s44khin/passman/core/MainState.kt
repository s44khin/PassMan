package com.s44khin.passman.core

import com.s44khin.passman.settings.master.presentation.data.StartScreen
import com.s44khin.passman.settings.master.presentation.data.ThemeMode
import com.s44khin.uikit.theme.PrimaryColor

data class MainState(
    val alwaysShowLabel: Boolean = false,
    val theme: ThemeMode = ThemeMode.System,
    val primaryColor: PrimaryColor = PrimaryColor.ORANGE,
    val startScreen: StartScreen = StartScreen.Codes,
)
