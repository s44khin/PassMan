package com.s44khin.common.api.navigation

import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder

interface ScreenRouter {

    fun navigateTo(destination: NavDestination)

    fun navigateTo(
        destination: NavDestination,
        builder: NavOptionsBuilder.(navHostController: NavHostController) -> Unit,
    )
}
