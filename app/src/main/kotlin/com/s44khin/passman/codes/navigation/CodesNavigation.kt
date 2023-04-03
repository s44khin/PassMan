package com.s44khin.passman.codes.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
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
        override val route = "${CodesNavigation.route}/add/{email}/{code}/{name}"

        operator fun invoke(
            email: String,
            code: String,
            name: String,
        ) = object : NavDestination {
            override val route = "${CodesNavigation.route}/add/$email/$code/$name"
        }
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

        composable(
            destination = CodesNavigation.Add,
            arguments = listOf(
                navArgument(name = "email") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                },
                navArgument(name = "code") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                },
                navArgument(name = "name") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email")
            val code = backStackEntry.arguments?.getString("code")
            val name = backStackEntry.arguments?.getString("name")

            AddCodeScreen(
                email = email,
                code = code,
                name = name
            )
        }

        composable(destination = CodesNavigation.Scanner) {
            ScannerScreen()
        }
    }
}
