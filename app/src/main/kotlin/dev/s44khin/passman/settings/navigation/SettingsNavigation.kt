package dev.s44khin.passman.settings.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.navigation.NavGraphBuilder
import dev.s44khin.passman.R
import dev.s44khin.passman.core.navigation.NavDestination
import dev.s44khin.passman.core.navigation.NavRootDestination
import dev.s44khin.passman.core.navigation.navigation
import dev.s44khin.passman.core.navigation.rootComposable
import dev.s44khin.passman.core.util.NativeText
import dev.s44khin.passman.settings.list.SettingsScreen

object SettingsNavigation : NavRootDestination {

    override val route = "settings"

    override val icon = Icons.Outlined.Settings

    override val label = NativeText.Resource(R.string.settings_label)

    override val startDestination = List

    object List : NavDestination {

        override val route = "${SettingsNavigation.route}/list"
    }
}

fun NavGraphBuilder.settingsNavigation() {
    navigation(rootDestination = SettingsNavigation) {
        rootComposable(destination = SettingsNavigation.List) {
            SettingsScreen()
        }
    }
}