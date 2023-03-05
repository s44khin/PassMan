package com.s44khin.passman.navigation

import androidx.navigation.NavHostController
import javax.inject.Inject

class ScreenRouter @Inject constructor(
    private val navHostController: NavHostController,
) {

    private val signalSubs = mutableMapOf<String, () -> Unit>()

    fun onSignal(key: String, action: () -> Unit) {
        signalSubs[key] = action
    }

    fun navigateTo(destination: NavDestination) {
        navHostController.navigate(destination.route)
    }

    fun back() {
        navHostController.popBackStack()
    }

    fun backWithSignal(signal: String) {
        signalSubs[signal]?.invoke()
        back()
    }
}