package dev.s44khin.passman.core.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

@Suppress("FunctionName")
inline fun ErrorHandler(
    crossinline onError: (Throwable) -> Unit = {},
): CoroutineExceptionHandler {
    return object : AbstractCoroutineContextElement(CoroutineExceptionHandler), CoroutineExceptionHandler {
        override fun handleException(context: CoroutineContext, exception: Throwable) {
            onError.invoke(exception)
        }
    }
}