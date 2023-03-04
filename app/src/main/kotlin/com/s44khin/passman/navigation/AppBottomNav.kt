package com.s44khin.passman.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.s44khin.passman.R
import com.s44khin.passman.codes.navigation.CodesNavigation
import com.s44khin.passman.settings.navigation.SettingsNavigation
import com.s44khin.uikit.widgets.BottomNav
import com.s44khin.uikit.widgets.BottomNavItem

private val bottomNavItems = listOf(
    AppBottomNavItem(
        icon = Icons.Rounded.Code,
        label = R.string.codes_label,
        route = CodesNavigation.route
    ),

    AppBottomNavItem(
        icon = Icons.Rounded.Settings,
        label = R.string.settings_label,
        route = SettingsNavigation.route
    )
)

@Composable
fun AppBottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNav {
        bottomNavItems.forEach { navItem ->
            val selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true

            BottomNavItem(
                selected = selected,
                icon = navItem.icon,
                label = stringResource(navItem.label),
                onClick = {
                    navController.navigate(navItem.route) {
                        if (!selected) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Immutable
private data class AppBottomNavItem(
    val icon: ImageVector,
    @StringRes val label: Int,
    val route: String,
)
