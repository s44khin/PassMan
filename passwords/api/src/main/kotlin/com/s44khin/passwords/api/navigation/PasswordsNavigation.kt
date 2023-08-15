package com.s44khin.passwords.api.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import com.s44khin.common.api.navigation.BottomNavigationItem
import com.s44khin.common.api.navigation.NavDestination
import com.s44khin.common.api.util.NativeText
import com.s44khin.passwords.api.R

object PasswordsNavigation : BottomNavigationItem {

    override val route = "passwords"
    override val icon = Icons.Default.Password
    override val label = NativeText.Resource(R.string.passwords)
    override val showBottomNavigation = true

    object List : NavDestination {

        override val route = "${PasswordsNavigation.route}/list"
        override val showBottomNavigation = true
    }

    object Detail : NavDestination {

        override val route = "${PasswordsNavigation.route}/detail"
        override val showBottomNavigation = true
    }
}
