package com.s44khin.passman.navigation.extensions

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.s44khin.passman.navigation.NavDestination

fun NavGraphBuilder.composable(
    destination: NavDestination,
    arguments: List<NamedNavArgument> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = destination.route,
        arguments = arguments,
        content = content
    )
}

fun NavGraphBuilder.navigation(
    rootDestination: NavDestination,
    startDestination: NavDestination,
    builder: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = startDestination.route,
        route = rootDestination.route,
        builder = builder,
    )
}
