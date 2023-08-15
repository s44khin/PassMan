package com.s44khin.common.api.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import java.util.UUID

@Immutable
open class SideEffect {

    val uuid: String = UUID.randomUUID().toString()
}

@Composable
fun <Effect : SideEffect> SideEffect(
    effect: Effect?,
    timeMillis: Long = 3000,
    onEnd: (Effect?) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    if (effect != null) {
        LaunchedEffect(effect.uuid) {
            delay(timeMillis)
            onEnd(effect)
        }
    }
}
