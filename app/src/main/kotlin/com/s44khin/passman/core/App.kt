package com.s44khin.passman.core

import android.app.Application
import com.s44khin.common.api.di.ComponentStorageImpl
import com.s44khin.common.api.di.FeatureDependenciesMap
import com.s44khin.common.api.di.FeatureDependenciesProvider
import com.s44khin.common.api.navigation.createNavHostController
import com.s44khin.passman.di.AppComponent
import javax.inject.Inject

class App : Application(), FeatureDependenciesProvider {

    lateinit var appComponent: AppComponent

    @Inject
    @Suppress("ProtectedInFinal")
    override lateinit var dependencies: FeatureDependenciesMap
        protected set

    @Inject
    lateinit var componentStorage: ComponentStorageImpl

    override fun onCreate() {
        super.onCreate()

        appComponent = AppComponent.create(
            context = applicationContext,
            navHostController = createNavHostController(applicationContext)
        )

        appComponent.inject(this)

        componentStorage.initialize()
    }
}
