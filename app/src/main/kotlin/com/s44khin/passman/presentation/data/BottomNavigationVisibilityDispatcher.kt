package com.s44khin.passman.presentation.data

import androidx.navigation.NavHostController
import com.s44khin.auth.api.navigation.AuthNavigation
import com.s44khin.codes.api.navigation.CodesNavigation
import com.s44khin.passwords.api.navigation.PasswordsNavigation
import javax.inject.Inject

class BottomNavigationVisibilityDispatcher @Inject constructor(
    private val navHostController: NavHostController,
) {

    suspend fun collectBottomNavigationVisibility(onChanges: (Boolean) -> Unit) {
        navHostController.currentBackStackEntryFlow.collect {
            val currentRoute = it.destination.route
            onChanges(currentRoute.visibilityFromString())
        }
    }

    private fun String?.visibilityFromString() = when (this) {
        AuthNavigation.Login.route -> AuthNavigation.Login.showBottomNavigation
        PasswordsNavigation.List.route -> PasswordsNavigation.List.showBottomNavigation
        PasswordsNavigation.Detail.route -> PasswordsNavigation.Detail.showBottomNavigation
        CodesNavigation.List.route -> PasswordsNavigation.List.showBottomNavigation
        else -> true
    }
}
