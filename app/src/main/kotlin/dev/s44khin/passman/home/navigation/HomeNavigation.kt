package dev.s44khin.passman.home.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.navigation.NavGraphBuilder
import dev.s44khin.passman.R
import dev.s44khin.passman.core.navigation.NavDestination
import dev.s44khin.passman.core.navigation.NavRootDestination
import dev.s44khin.passman.core.navigation.composable
import dev.s44khin.passman.core.navigation.navigation
import dev.s44khin.passman.core.navigation.rootComposable
import dev.s44khin.passman.core.util.NativeText
import dev.s44khin.passman.home.detail.DetailScreen
import dev.s44khin.passman.home.list.presentation.HomeScreen

object HomeNavigation : NavRootDestination {

    override val route = "home"

    override val icon = Icons.Outlined.Home

    override val label = NativeText.Resource(R.string.home_label)

    override val startDestination = List

    object List : NavDestination {

        override val route = "${HomeNavigation.route}/list"
    }

    object Detail : NavDestination {

        override val route = "${HomeNavigation.route}/detail"
    }
}

fun NavGraphBuilder.homeNavigation() {
    navigation(rootDestination = HomeNavigation) {
        rootComposable(destination = HomeNavigation.List) {
            HomeScreen()
        }

        composable(destination = HomeNavigation.Detail) {
            DetailScreen()
        }
    }
}
