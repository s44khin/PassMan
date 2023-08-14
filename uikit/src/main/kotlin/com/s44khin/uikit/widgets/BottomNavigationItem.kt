package com.s44khin.uikit.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

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
