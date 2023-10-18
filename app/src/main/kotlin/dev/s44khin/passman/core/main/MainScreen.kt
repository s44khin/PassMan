package dev.s44khin.passman.core.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.s44khin.passman.core.navigation.bottomNavigationItems
import dev.s44khin.passman.core.navigation.bottomNavigationItemsRouts
import dev.s44khin.passman.core.navigation.navigate
import dev.s44khin.passman.home.navigation.HomeNavigation
import dev.s44khin.passman.home.navigation.homeNavigation
import dev.s44khin.passman.settings.navigation.settingsNavigation
import dev.s44khin.uikit.theme.PassManTheme
import dev.s44khin.uikit.widgets.AppBottomNavItem

@Composable
fun MainScreen(
    navHostController: NavHostController,
    onAction: (MainAction) -> Unit,
) {
    PassManTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            rememberNavController()
            NavHost(
                modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
                navController = navHostController,
                startDestination = HomeNavigation.route
            ) {
                homeNavigation()
                settingsNavigation()
            }

            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            AnimatedVisibility(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                visible = currentDestination?.route in bottomNavigationItemsRouts,
                enter = slideInVertically { it },
                exit = slideOutVertically { it }
            ) {
                NavigationBar {
                    bottomNavigationItems.forEach { navRootDestination ->
                        AppBottomNavItem(
                            icon = navRootDestination.icon,
                            label = navRootDestination.label.resolve(),
                            selected = currentDestination?.hierarchy?.any { it.route == navRootDestination.route } == true,
                            onClick = {
                                navHostController.navigate(navRootDestination) {
                                    popUpTo(navHostController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}