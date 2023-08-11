package com.s44khin.passman.core

import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class CleanUpUseCase @Inject constructor(private val clearableSet: Set<@JvmSuppressWildcards Clearable>) {

    suspend fun execute() = coroutineScope {
        clearableSet.forEach { it.clean() }
    }
}
