package dev.s44khin.passman.core.navigation

import dev.s44khin.passman.home.navigation.HomeNavigation
import dev.s44khin.passman.settings.navigation.SettingsNavigation

val bottomNavigationItems = listOf(
    HomeNavigation,
    SettingsNavigation
)

val bottomNavigationItemsRouts = listOf(
    HomeNavigation.List.route,
    SettingsNavigation.List.route
)
