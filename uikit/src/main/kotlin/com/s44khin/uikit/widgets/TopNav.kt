package com.s44khin.uikit.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.util.clickableWithoutRipple

private val TopNavigationHeight = 48.5.dp

@Immutable
data class TopNavIcon(
    val icon: ImageVector,
    val visible: Boolean = true,
    val onClick: () -> Unit,
)

@Composable
fun TopNav(
    modifier: Modifier = Modifier,
    navIcon: TopNavIcon? = null,
    label: String,
    backgroundColor: Color = AppTheme.colors.background,
    contentColor: Color = AppTheme.colors.textOnBackground,
    onLabelClick: () -> Unit = {},
    endIcon: TopNavIcon? = null,
) {
    TopNav(
        modifier = modifier,
        navIcon = navIcon,
        label = label,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        onLabelClick = onLabelClick,
        endIcons = if (endIcon != null) listOf(endIcon) else emptyList(),
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TopNav(
    modifier: Modifier = Modifier,
    navIcon: TopNavIcon? = null,
    label: String,
    backgroundColor: Color = AppTheme.colors.background,
    contentColor: Color = AppTheme.colors.textOnBackground,
    onLabelClick: () -> Unit = {},
    endIcons: List<TopNavIcon>,
) {
    val animatedBackgroundColor by animateColorAsState(backgroundColor)
    val animatedContentColor by animateColorAsState(contentColor)

    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .background(color = animatedBackgroundColor)
                .statusBarsPadding()
                .fillMaxWidth()
                .height(TopNavigationHeight - 0.5.dp)
        ) {
            if (navIcon != null) {
                this@Column.AnimatedVisibility(
                    visible = navIcon.visible,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut(),
                ) {
                    IconButton(
                        modifier = Modifier.align(Alignment.CenterStart),
                        onClick = { navIcon.onClick() }
                    ) {
                        Icon(
                            imageVector = navIcon.icon,
                            contentDescription = navIcon.icon.name,
                            tint = animatedContentColor,
                        )
                    }
                }
            }

            Text(
                modifier = Modifier
                    .clickableWithoutRipple { onLabelClick() }
                    .align(Alignment.Center),
                text = label,
                fontWeight = FontWeight.Bold,
                color = animatedContentColor,
            )

            endIcons.forEach { endNavIcon ->
                this@Column.AnimatedVisibility(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    visible = endNavIcon.visible,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut(),
                ) {
                    IconButton(onClick = { endNavIcon.onClick() }) {
                        Icon(
                            imageVector = endNavIcon.icon,
                            contentDescription = endNavIcon.icon.name,
                            tint = animatedContentColor,
                        )
                    }
                }
            }
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 0.5.dp
        )
    }
}
