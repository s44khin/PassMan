package com.s44khin.passman.common

import dev.turingcomplete.kotlinonetimepassword.GoogleAuthenticator
import java.time.LocalDateTime
import java.time.temporal.ChronoField
import java.util.Date
import javax.inject.Inject

class TotpHelper @Inject constructor() {

    fun getCurrentCode(secretCode: String) = getCode(secretCode, 0)

    fun getNextCode(secretCode: String, updateTimer: Int) = getCode(secretCode, updateTimer.toLong() * 1000)

    fun getTimer2(updateTimer: Int): Int {
        val now = LocalDateTime.now()
        var nowSeconds = now.second

        while (nowSeconds >= updateTimer) {
            nowSeconds -= updateTimer
        }

        return updateTimer - nowSeconds
    }

    private fun getCode(secretCode: String, additionalTimer: Long): String {
        val timestamp =
            Date(System.currentTimeMillis() - LocalDateTime.now().get(ChronoField.MILLI_OF_SECOND) + additionalTimer)
        return GoogleAuthenticator(secretCode.toByteArray()).generate(timestamp)
    }
}