package com.s44khin.passman.navigation

import androidx.navigation.NavHostController

class ScreenRouter(
    private val navHostController: NavHostController,
) {

    fun navigateTo(destination: NavDestination) {
        navHostController.navigate(destination.route)
    }

    fun back() {
        navHostController.popBackStack()
    }
}