package com.s44khin.passman.codes.navigation

import androidx.navigation.NavGraphBuilder
import com.s44khin.passman.codes.add.presentation.AddCodeScreen
import com.s44khin.passman.codes.list.presentation.CodesListScreen
import com.s44khin.passman.codes.qrscanner.presentation.ScannerScreen
import com.s44khin.passman.navigation.NavDestination
import com.s44khin.passman.navigation.extensions.composable
import com.s44khin.passman.navigation.extensions.navigation

object CodesNavigation : NavDestination {

    override val route = "codes"

    object List : NavDestination {
        override val route = "${CodesNavigation.route}/list"
    }

    object Add : NavDestination {
        override val route = "${CodesNavigation.route}/add/"
    }

    object Scanner : NavDestination {
        override val route = "${CodesNavigation.route}/scanner"
    }
}

fun NavGraphBuilder.codesNavigation() {
    navigation(rootDestination = CodesNavigation, startDestination = CodesNavigation.List) {
        composable(destination = CodesNavigation.List) {
            CodesListScreen()
        }

        composable(destination = CodesNavigation.Add) {
            AddCodeScreen()
        }

        composable(destination = CodesNavigation.Scanner) {
            ScannerScreen()
        }
    }
}
