package com.s44khin.uikit.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme

val BottomNavigationHeight = 56.dp

@Composable
fun BottomNav(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                color = AppTheme.colors.background
            )
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .navigationBarsPadding()
            .fillMaxWidth()
            .height(BottomNavigationHeight)
            .selectableGroup()

    ) {
        content()
    }
}

@Composable
fun RowScope.BottomNavItem(
    selected: Boolean,
    label: String,
    icon: ImageVector,
    alwaysShowLabel: Boolean = false,
    onClick: () -> Unit,
) {
    BottomNavigationItem(
        selected = selected,
        label = { Text(text = label) },
        icon = { Icon(imageVector = icon, contentDescription = icon.name) },
        alwaysShowLabel = alwaysShowLabel,
        selectedContentColor = AppTheme.colors.primary,
        onClick = onClick,
        unselectedContentColor = AppTheme.colors.textOnBackgroundVariant
    )
}
