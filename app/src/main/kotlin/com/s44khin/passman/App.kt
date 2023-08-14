package com.s44khin.passman

import android.app.Application
import com.s44khin.common.api.di.ComponentStorageImpl
import com.s44khin.common.api.di.FeatureDependenciesMap
import com.s44khin.common.api.di.FeatureDependenciesProvider
import com.s44khin.passman.di.AppComponent
import com.s44khin.passman.di.DaggerAppComponent
import javax.inject.Inject

class App : Application(), FeatureDependenciesProvider {

    lateinit var appComponent: AppComponent

    @Inject
    override lateinit var dependencies: FeatureDependenciesMap
        protected set

    @Inject
    lateinit var componentStorage: ComponentStorageImpl

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .bindContext(applicationContext)
            .build()

        appComponent.inject(this)

        componentStorage.initialize()
    }
}
