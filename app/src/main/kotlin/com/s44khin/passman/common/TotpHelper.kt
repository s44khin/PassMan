package com.s44khin.passman.common

import dev.turingcomplete.kotlinonetimepassword.GoogleAuthenticator
import java.util.Date
import javax.inject.Inject

class TotpHelper @Inject constructor() {

    fun getCurrentCode(secretCode: String) = getCode(secretCode, 0)

    fun getNextCode(secretCode: String, updateTimer: Int) = getCode(secretCode, updateTimer.toLong() * 1000)

    fun getTimer(updateTimer: Int): Int {
        var seconds = (System.currentTimeMillis() % 100000) / 1000

        while (seconds >= updateTimer) {
            seconds -= updateTimer
        }

        return updateTimer - seconds.toInt()
    }

    private fun getCode(secretCode: String, additionalTimer: Long): String {
        val timestamp = Date(System.currentTimeMillis() + additionalTimer)
        return GoogleAuthenticator(secretCode.toByteArray()).generate(timestamp)
    }

//    sealed class GenerateResult {
//
//        data class Success(val code: String) : GenerateResult()
//
//        object Invalid : GenerateResult()
//    }
}