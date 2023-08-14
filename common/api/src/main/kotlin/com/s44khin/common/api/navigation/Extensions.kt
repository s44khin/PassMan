package com.s44khin.common.api.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.navigation(
    rootDestination: NavDestination,
    startDestination: NavDestination,
    builder: NavGraphBuilder.() -> Unit,
) {
    navigation(
        route = rootDestination.route,
        startDestination = startDestination.route,
        builder = builder,
    )
}

fun NavGraphBuilder.composable(
    destination: NavDestination,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
) {
    composable(
        route = destination.route,
        content = content,
    )
}
