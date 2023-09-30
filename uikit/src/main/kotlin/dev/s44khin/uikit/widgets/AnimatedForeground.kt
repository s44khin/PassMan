package dev.s44khin.uikit.widgets

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dev.s44khin.uikit.util.clickableWithoutRipple

@Composable
fun AnimatedForeground(
    modifier: Modifier = Modifier,
    visible: Boolean,
    onClick: () -> Unit,
) {
    val animatedAlpha by animateFloatAsState(
        targetValue = if (visible) 0.6f else 0f,
        label = "animatedAlpha"
    )

    Spacer(
        modifier = modifier
            .fillMaxSize()
            .let {
                if (visible) {
                    it.clickableWithoutRipple {
                        onClick()
                    }
                } else {
                    it
                }
            }
            .background(
                color = MaterialTheme.colorScheme.background.copy(alpha = animatedAlpha)
            )
    )
}
