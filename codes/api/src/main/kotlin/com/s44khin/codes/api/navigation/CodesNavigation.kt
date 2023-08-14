package com.s44khin.codes.api.navigation

import androidx.navigation.NavGraphBuilder
import com.s44khin.codes.CodesScreen
import com.s44khin.common.api.navigation.NavDestination
import com.s44khin.common.api.navigation.composable
import com.s44khin.common.api.navigation.navigation

object CodesNavigation : NavDestination {

    override val route = "codes"

    object List : NavDestination {

        override val route = "${CodesNavigation.route}/list"
    }
}

fun NavGraphBuilder.codesNavigation() {
    navigation(rootDestination = CodesNavigation, startDestination = CodesNavigation.List) {
        composable(destination = CodesNavigation.List) {
            CodesScreen()
        }
    }
}