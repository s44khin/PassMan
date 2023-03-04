package com.s44khin.passman.settings.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import com.s44khin.passman.navigation.NavDestination
import com.s44khin.passman.navigation.extensions.composable
import com.s44khin.passman.navigation.extensions.navigation

object SettingsNavigation : NavDestination {

    override val route = "settings"

    object Todo : NavDestination {
        override val route = "${SettingsNavigation.route}/todo"
    }
}

fun NavGraphBuilder.settingsNavigation() {
    navigation(rootDestination = SettingsNavigation, startDestination = SettingsNavigation.Todo) {
        composable(destination = SettingsNavigation.Todo) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Todo"
                )
            }
        }
    }
}
