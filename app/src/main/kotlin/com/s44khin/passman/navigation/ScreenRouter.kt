package com.s44khin.passman.navigation

import androidx.navigation.NavHostController
import javax.inject.Inject

class ScreenRouter @Inject constructor(
    private val navHostController: NavHostController,
) {

    fun navigateTo(destination: NavDestination) {
        navHostController.navigate(destination.route)
    }
}