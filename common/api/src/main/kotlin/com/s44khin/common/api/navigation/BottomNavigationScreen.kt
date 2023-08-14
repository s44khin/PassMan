package com.s44khin.common.api.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Pin
import androidx.compose.ui.graphics.vector.ImageVector
import com.s44khin.common.api.R
import com.s44khin.common.api.util.NativeText

val bottomNavigationScreens = listOf(
    BottomNavigationScreen.Codes,
    BottomNavigationScreen.Passwords,
    BottomNavigationScreen.Menu,
)

sealed class BottomNavigationScreen : NavDestination {

    abstract val icon: ImageVector

    abstract val label: NativeText

    data object Codes : BottomNavigationScreen() {
        override val route = "codes"
        override val icon = Icons.Default.Pin
        override val label = NativeText.Resource(R.string.codes)
    }

    data object Passwords : BottomNavigationScreen() {
        override val route = "passwords"
        override val icon = Icons.Default.Password
        override val label = NativeText.Resource(R.string.passwords)
    }

    data object Menu : BottomNavigationScreen() {
        override val route = "menu"
        override val icon = Icons.Default.Menu
        override val label = NativeText.Resource(R.string.menu)
    }
}
