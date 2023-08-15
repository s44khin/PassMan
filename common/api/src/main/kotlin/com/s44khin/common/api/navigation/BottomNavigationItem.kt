package com.s44khin.common.api.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.s44khin.common.api.util.NativeText

interface BottomNavigationItem : NavDestination {
    val label: NativeText
    val icon: ImageVector
}
