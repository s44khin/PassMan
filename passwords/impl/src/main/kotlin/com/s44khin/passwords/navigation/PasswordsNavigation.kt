package com.s44khin.passwords.navigation

import androidx.navigation.NavGraphBuilder
import com.s44khin.common.api.navigation.composable
import com.s44khin.common.api.navigation.navigation
import com.s44khin.common.api.navigation.rootComposable
import com.s44khin.passwords.api.navigation.PasswordsNavigation
import com.s44khin.passwords.detail.master.PasswordDetailScreen
import com.s44khin.passwords.list.master.PasswordsScreen

fun NavGraphBuilder.passwordsNavigation() {
    navigation(
        rootDestination = PasswordsNavigation,
        startDestination = PasswordsNavigation.List
    ) {
        rootComposable(destination = PasswordsNavigation.List) {
            PasswordsScreen()
        }

        composable(destination = PasswordsNavigation.Detail) {
            PasswordDetailScreen()
        }
    }

}
