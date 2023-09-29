package dev.s44khin.passman.core.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.s44khin.passman.core.base.actionHandler.ActionHandler

@Suppress("NOTHING_TO_INLINE")
@Composable
inline fun <ACTION> ActionHandler<ACTION>.rememberOnAction(): ((ACTION) -> Unit) {
    return remember { { this.onAction(it) } }
}