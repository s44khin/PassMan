package com.s44khin.passman

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.s44khin.codes.api.navigation.codesNavigation
import com.s44khin.common.api.navigation.AppNavHost
import com.s44khin.common.api.navigation.bottomNavigationScreens
import com.s44khin.passwords.api.navigation.PasswordsNavigation
import com.s44khin.passwords.api.navigation.passwordsNavigation
import com.s44khin.uikit.widgets.BottomNavigationItem

@Composable
internal fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val navHostController = rememberNavController()

        AppNavHost(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            navHostController = navHostController,
            startDestination = PasswordsNavigation
        ) {
            passwordsNavigation()
            codesNavigation()
        }

        BottomAppBar(modifier = Modifier.fillMaxWidth()) {
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            bottomNavigationScreens.forEach { screen ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route },
                    icon = screen.icon,
                    label = screen.label.resolve(),
                    onClick = {
                        navHostController.navigate(screen.route) {
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
