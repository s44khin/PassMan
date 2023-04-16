package com.s44khin.uikit.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    val animatedBackgroundColor by animateColorAsState(
        targetValue = if (enabled) AppTheme.colors.primary else AppTheme.colors.divider
    )

    val animatedContentColor by animateColorAsState(
        targetValue = if (enabled) AppTheme.colors.textOnPrimary else AppTheme.colors.textOnBackgroundVariant
    )

    val interactionSource = remember { MutableInteractionSource() }
    val pressedState by interactionSource.collectIsPressedAsState()

    val animatedElevation by animateDpAsState(
        targetValue = if (pressedState) 8.dp else 0.dp
    )

    Box(
        modifier = modifier
            .height(48.dp)
            .shadow(
                elevation = animatedElevation,
                shape = AppTheme.shapes.small,
            )
            .background(
                color = animatedBackgroundColor,
                shape = AppTheme.shapes.small,
            )
            .clip(AppTheme.shapes.small)
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                enabled = enabled,
                onClick = onClick
            )
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            text = label,
            color = animatedContentColor,
        )
    }
}

@Composable
fun BottomButton(
    label: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    ) {
        AppDivider(modifier = Modifier.fillMaxWidth())

        AppButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = label,
            enabled = enabled,
            onClick = onClick
        )
    }
}

@Composable
fun AppButtonSmall(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    AppButton(
        modifier = modifier.height(36.dp),
        label = label,
        enabled = enabled,
        onClick = onClick,
    )
}
