package dev.s44khin.passman.core.navigation

import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class ScreenRouter @Inject constructor(
    private val navHostController: NavHostController,
) {

    fun navigateTo(navDestination: NavDestination) {
        navHostController.navigate(navDestination)
    }

    fun navigateTo(navDestination: NavDestination, builder: NavOptionsBuilder.() -> Unit) {
        navHostController.navigate(
            navDestination = navDestination,
            builder = builder,
        )
    }
}