package com.s44khin.passman.codes.navigation

import androidx.navigation.NavGraphBuilder
import com.s44khin.passman.codes.master.presentation.CodesListScreen
import com.s44khin.passman.navigation.NavDestination
import com.s44khin.passman.navigation.extensions.composable
import com.s44khin.passman.navigation.extensions.navigation

object CodesNavigation : NavDestination {

    override val route = "codes"

    object List : NavDestination {
        override val route = "${CodesNavigation.route}/list"
    }
}

fun NavGraphBuilder.codesNavigation() {
    navigation(rootDestination = CodesNavigation, startDestination = CodesNavigation.List) {
        composable(destination = CodesNavigation.List) {
            CodesListScreen()
        }
    }
}
