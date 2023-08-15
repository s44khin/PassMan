package com.s44khin.common.navigation

import androidx.navigation.NavHostController
import com.s44khin.common.api.navigation.NavDestination
import com.s44khin.common.api.navigation.ScreenRouter
import javax.inject.Inject

class ScreenRouterImpl @Inject constructor(
    private val navHostController: NavHostController,
) : ScreenRouter {

    override fun navigateTo(destination: NavDestination) {
        navHostController.navigate(route = destination.route)
    }
}