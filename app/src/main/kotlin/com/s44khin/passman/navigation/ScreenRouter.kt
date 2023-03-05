package com.s44khin.passman.navigation

import androidx.navigation.NavHostController

class ScreenRouter(
    private val navHostController: NavHostController,
) {

    private val subscribers = mutableMapOf<String, () -> Unit>()

    fun onSignal(key: String, action: () -> Unit) {
        subscribers[key] = action
    }

    fun navigateTo(destination: NavDestination) {
        navHostController.navigate(destination.route)
    }

    fun back() {
        navHostController.popBackStack()
    }

    fun backWithSignal(signal: String) {
        subscribers[signal]?.invoke()
        back()
    }
}