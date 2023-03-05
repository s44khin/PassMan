package com.s44khin.passman.core

import android.content.Context
import android.content.Intent

class AppRouter(private val context: Context) {

    fun restart() {
        val packageManager = context.packageManager
        val intent = packageManager.getLaunchIntentForPackage(context.packageName)

        if (intent != null) {
            val mainIntent = Intent.makeRestartActivityTask(intent.component)
            context.startActivity(mainIntent)
            Runtime.getRuntime().exit(0)
        }
    }
}