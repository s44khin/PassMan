package com.s44khin.passman.core

import android.app.Application
import com.s44khin.passman.di.AppComponent
import com.s44khin.passman.navigation.createNavController

class PassManApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.create(
            context = this,
            navHostController = createNavController(this),
        )
    }
}
