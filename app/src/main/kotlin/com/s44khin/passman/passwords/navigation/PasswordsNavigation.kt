package com.s44khin.passman.passwords.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import com.s44khin.passman.navigation.NavDestination
import com.s44khin.passman.navigation.extensions.composable
import com.s44khin.passman.navigation.extensions.navigation
import com.s44khin.uikit.theme.AppTheme

object PasswordsNavigation : NavDestination {

    override val route = "passwords"

    object List : NavDestination {
        override val route = "${PasswordsNavigation.route}/list"
    }
}

fun NavGraphBuilder.passwordsNavigation() {
    navigation(rootDestination = PasswordsNavigation, startDestination = PasswordsNavigation.List) {
        composable(destination = PasswordsNavigation.List) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    color = AppTheme.colors.textOnBackground,
                    text = "TODO"
                )
            }
        }
    }
}
