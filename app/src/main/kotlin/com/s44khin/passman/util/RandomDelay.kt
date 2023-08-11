package com.s44khin.passman.util

import kotlinx.coroutines.delay

suspend fun randomDelay(range: LongRange = 1L..5L) {
    delay(range.random())
}
