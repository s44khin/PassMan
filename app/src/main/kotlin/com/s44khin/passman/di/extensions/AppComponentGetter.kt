package com.s44khin.passman.di

import android.content.Context
import com.s44khin.passman.core.PassManApp

val Context.appComponent: AppComponent
    get() = when (this) {
        is PassManApp -> appComponent
        else -> applicationContext.appComponent
    }
