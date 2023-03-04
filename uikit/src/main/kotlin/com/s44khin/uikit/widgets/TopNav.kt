package com.s44khin.uikit.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.util.clickableWithoutRipple

private val TopNavigationHeight = 48.dp
private val TopNavigationShape = 24.dp

@Immutable
data class TopNavIcon(
    val icon: ImageVector,
    val onClick: () -> Unit,
)

@Composable
fun TopNav(
    modifier: Modifier = Modifier,
    navIcon: TopNavIcon? = null,
    label: String,
    onLabelClick: () -> Unit = {},
    endIcon: TopNavIcon? = null,
) {
    TopNav(
        modifier = modifier,
        navIcon = navIcon,
        label = label,
        onLabelClick = onLabelClick,
        endIcons = if (endIcon != null) listOf(endIcon) else emptyList(),
    )
}

@Composable
fun TopNav(
    modifier: Modifier = Modifier,
    navIcon: TopNavIcon? = null,
    label: String,
    onLabelClick: () -> Unit = {},
    endIcons: List<TopNavIcon>,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(bottomStart = TopNavigationShape, bottomEnd = TopNavigationShape))
            .background(
                color = AppTheme.colors.background,
                shape = RoundedCornerShape(bottomStart = TopNavigationShape, bottomEnd = TopNavigationShape)
            )
            .statusBarsPadding()
            .fillMaxWidth()
            .height(TopNavigationHeight)
    ) {
        if (navIcon != null) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterStart),
                onClick = { navIcon.onClick() }
            ) {
                Icon(
                    imageVector = navIcon.icon,
                    contentDescription = navIcon.icon.name,
                    tint = AppTheme.colors.textOnBackground,
                )
            }
        }

        Text(
            modifier = Modifier
                .clickableWithoutRipple { onLabelClick() }
                .align(Alignment.Center),
            text = label,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.textOnBackground,
        )

        if (endIcons.isNotEmpty()) {
            Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                endIcons.forEach { endNavIcon ->
                    IconButton(onClick = { endNavIcon.onClick() }) {
                        Icon(
                            imageVector = endNavIcon.icon,
                            contentDescription = endNavIcon.icon.name,
                            tint = AppTheme.colors.textOnBackground,
                        )
                    }
                }
            }
        }
    }
}
