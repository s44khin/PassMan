package com.s44khin.passman.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.s44khin.codes.navigation.codesNavigation
import com.s44khin.common.api.navigation.AppNavHost
import com.s44khin.passman.presentation.data.bottomNavigationItems
import com.s44khin.passwords.api.navigation.PasswordsNavigation
import com.s44khin.passwords.navigation.passwordsNavigation
import com.s44khin.uikit.widgets.BottomNavigationItem

@Composable
internal fun MainScreen(
    viewState: MainViewState,
    navHostController: NavHostController
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Box(modifier = Modifier.fillMaxSize()) {
        AppNavHost(
            modifier = Modifier.fillMaxSize(),
            navHostController = navHostController,
            startDestination = PasswordsNavigation
        ) {
            passwordsNavigation()
            codesNavigation()
        }

        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            visible = viewState.showBottomNavigation,
            enter = slideInVertically { it },
            exit = slideOutVertically { it },
        ) {
            BottomAppBar(modifier = Modifier.fillMaxWidth()) {
                bottomNavigationItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route },
                        icon = screen.icon,
                        label = screen.label.resolve(),
                        onClick = {
                            if (currentDestination?.hierarchy?.any { it.route == screen.route } != true) {
                                navHostController.navigate(screen.route) {
                                    popUpTo(screen.route) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
