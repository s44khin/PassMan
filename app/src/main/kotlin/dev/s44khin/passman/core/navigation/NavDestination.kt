package dev.s44khin.passman.core.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import dev.s44khin.passman.core.util.NativeText

interface NavRootDestination : NavDestination {

    val icon: ImageVector

    val label: NativeText

    val startDestination: NavDestination
}

interface NavDestination {

    val route: String
}
