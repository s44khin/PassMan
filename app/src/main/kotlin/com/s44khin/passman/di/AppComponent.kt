package com.s44khin.passman.di

import android.content.Context
import com.s44khin.common.di.CommonModule
import com.s44khin.passman.App
import com.s44khin.passman.di.modules.DiModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        FeatureDependenciesModule::class,
        DiModule::class,
        CommonModule::class,
    ]
)
interface AppComponent : AllFeaturesDependencies {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(place: App)
}
