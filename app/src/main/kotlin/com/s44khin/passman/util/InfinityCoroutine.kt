package com.s44khin.passman.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.infinity(
    context: CoroutineContext = EmptyCoroutineContext,
    delay: Long = 30000,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {

    return launch(
        context = context,
        start = start,
    ) {
        while (true) {
            block()
            delay(delay)
        }
    }
}