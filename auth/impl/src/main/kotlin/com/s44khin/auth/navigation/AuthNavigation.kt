package com.s44khin.auth.navigation

import androidx.navigation.NavGraphBuilder
import com.s44khin.auth.api.navigation.AuthNavigation
import com.s44khin.auth.login.LoginScreen
import com.s44khin.common.api.navigation.composable
import com.s44khin.common.api.navigation.navigation

fun NavGraphBuilder.authNavigation() {
    navigation(
        rootDestination = AuthNavigation,
        startDestination = AuthNavigation.Login,
    ) {
        composable(destination = AuthNavigation.Login) {
            LoginScreen()
        }
    }
}
