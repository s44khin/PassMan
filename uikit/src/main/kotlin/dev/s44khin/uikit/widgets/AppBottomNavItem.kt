package dev.s44khin.uikit.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val bottomNavHeight = 80.dp

@Composable
fun RowScope.AppBottomNavItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    NavigationBarItem(
        modifier = modifier,
        selected = selected,
        icon = { Icon(imageVector = icon, contentDescription = icon.name) },
        label = { Text(text = label) },
        onClick = onClick
    )
}