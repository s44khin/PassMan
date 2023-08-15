package com.s44khin.passman.di

import android.content.Context
import com.s44khin.passman.core.App

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }