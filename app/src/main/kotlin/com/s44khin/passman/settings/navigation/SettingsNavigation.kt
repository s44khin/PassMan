package com.s44khin.passman.settings.navigation

import androidx.navigation.NavGraphBuilder
import com.s44khin.passman.navigation.NavDestination
import com.s44khin.passman.navigation.extensions.composable
import com.s44khin.passman.navigation.extensions.navigation
import com.s44khin.passman.settings.master.presentation.SettingsScreen

object SettingsNavigation : NavDestination {

    override val route = "settings"

    object List : NavDestination {
        override val route = "${SettingsNavigation.route}/list"
    }
}

fun NavGraphBuilder.settingsNavigation() {
    navigation(rootDestination = SettingsNavigation, startDestination = SettingsNavigation.List) {
        composable(destination = SettingsNavigation.List) {
            SettingsScreen()
        }
    }
}
