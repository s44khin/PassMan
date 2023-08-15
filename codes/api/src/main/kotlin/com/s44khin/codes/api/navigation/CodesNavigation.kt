package com.s44khin.codes.api.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pin
import com.s44khin.codes.api.R
import com.s44khin.common.api.navigation.BottomNavigationItem
import com.s44khin.common.api.navigation.NavDestination
import com.s44khin.common.api.util.NativeText

object CodesNavigation : BottomNavigationItem {

    override val route = "codes"
    override val icon = Icons.Default.Pin
    override val label = NativeText.Resource(R.string.codes)
    override val showBottomNavigation = true

    object List : NavDestination {

        override val route = "${CodesNavigation.route}/list"
        override val showBottomNavigation = true
    }
}