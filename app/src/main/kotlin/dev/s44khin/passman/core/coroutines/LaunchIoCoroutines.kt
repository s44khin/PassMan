package dev.s44khin.passman.core.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun CoroutineScope.launchIoCoroutine(
    errorHandler: CoroutineExceptionHandler? = null,
    block: suspend CoroutineScope.() -> Unit,
) {
    launch(
        context = if (errorHandler != null) Dispatchers.IO + errorHandler else Dispatchers.IO,
        block = block,
    )
}