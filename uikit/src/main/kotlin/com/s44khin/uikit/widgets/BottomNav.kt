package com.s44khin.uikit.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme

val BottomNavigationHeight = 80.5.dp

@Composable
fun BottomNav(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        AppDivider(modifier = Modifier.fillMaxWidth())

        Surface(tonalElevation = 0.dp) {
            Row(
                modifier = Modifier
                    .background(color = AppTheme.colors.background)
                    .navigationBarsPadding()
                    .fillMaxWidth()
                    .height(BottomNavigationHeight - 0.5.dp)
                    .selectableGroup()
            ) {
                content()
            }
        }
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
    NavigationBarItem(
        selected = selected,
        label = { Text(text = label) },
        icon = { Icon(imageVector = icon, contentDescription = icon.name) },
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedTextColor = AppTheme.colors.primary,
            selectedIconColor = AppTheme.colors.textOnPrimary,
            indicatorColor = AppTheme.colors.primary,
            unselectedTextColor = AppTheme.colors.textOnBackgroundVariant,
            unselectedIconColor = AppTheme.colors.textOnBackgroundVariant,
        ),
        onClick = onClick,
    )
}
