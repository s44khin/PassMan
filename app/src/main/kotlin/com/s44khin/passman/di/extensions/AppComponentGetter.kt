package com.s44khin.passman.di.extensions

import android.content.Context
import com.s44khin.passman.core.PassManApp
import com.s44khin.passman.di.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is PassManApp -> appComponent
        else -> applicationContext.appComponent
    }
