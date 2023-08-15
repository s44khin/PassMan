package com.s44khin.auth.api.navigation

import com.s44khin.common.api.navigation.NavDestination

object AuthNavigation : NavDestination {

    override val route = "auth"
    override val showBottomNavigation = false

    object Login : NavDestination {

        override val route = "${AuthNavigation.route}/login"
        override val showBottomNavigation = false
    }
}
