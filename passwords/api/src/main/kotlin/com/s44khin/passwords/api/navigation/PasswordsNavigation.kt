package com.s44khin.passwords.api.navigation

import androidx.navigation.NavGraphBuilder
import com.s44khin.common.api.navigation.NavDestination
import com.s44khin.common.api.navigation.composable
import com.s44khin.common.api.navigation.navigation
import com.s44khin.passwords.PasswordsScreen

object PasswordsNavigation : NavDestination {

    override val route = "passwords"

    object List : NavDestination {

        override val route = "${PasswordsNavigation.route}/list"
    }
}

fun NavGraphBuilder.passwordsNavigation() {
    navigation(rootDestination = PasswordsNavigation, startDestination = PasswordsNavigation.List) {
        composable(destination = PasswordsNavigation.List) {
            PasswordsScreen()
        }
    }
}
