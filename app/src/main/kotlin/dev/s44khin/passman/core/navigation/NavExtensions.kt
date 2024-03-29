package dev.s44khin.passman.core.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.navigation(
    rootDestination: NavRootDestination,
    builder: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = rootDestination.route,
        startDestination = rootDestination.startDestination.route,
        builder = builder,
    )
}

fun NavGraphBuilder.rootComposable(
    destination: NavDestination,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = destination.route,
        content = content
    )
}

fun NavGraphBuilder.composable(
    destination: NavDestination,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = destination.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(500),
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(500)
            )
        },
        content = content
    )
}

fun NavController.navigate(navDestination: NavDestination) {
    navigate(
        route = navDestination.route,
    )
}

fun NavController.navigate(navDestination: NavDestination, builder: NavOptionsBuilder.() -> Unit) {
    navigate(
        route = navDestination.route,
        builder = builder,
    )
}
