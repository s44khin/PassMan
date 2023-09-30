package dev.s44khin.uikit.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.clickableWithoutRipple(
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    onClick: () -> Unit
) = composed {
    val finalInteractionSource = remember {
        interactionSource ?: MutableInteractionSource()
    }

    clickable(
        enabled = enabled,
        interactionSource = finalInteractionSource,
        indication = null,
        onClick = onClick,
    )
}