package com.s44khin.uikit.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val bottomNavigationHeight = 80.dp

val navigationBarsHeight: Dp
    @Composable
    get() = bottomNavigationHeight + with(LocalDensity.current) {
        WindowInsets.navigationBars.getBottom(
            LocalDensity.current
        ).toDp()
    }

@Composable
fun RowScope.BottomNavigationItem(
    selected: Boolean?,
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
) {
    NavigationBarItem(
        selected = selected == true,
        alwaysShowLabel = true,
        icon = { Icon(imageVector = icon, contentDescription = icon.name) },
        label = { Text(text = label) },
        onClick = onClick
    )
}
