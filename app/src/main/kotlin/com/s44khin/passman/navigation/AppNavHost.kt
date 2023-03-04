package com.s44khin.passman.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.s44khin.passman.codes.navigation.CodesNavigation
import com.s44khin.passman.codes.navigation.codesNavigation
import com.s44khin.passman.settings.navigation.settingsNavigation

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(modifier = modifier, navController = navHostController, startDestination = CodesNavigation.route) {
        codesNavigation()
        settingsNavigation()
    }
}
