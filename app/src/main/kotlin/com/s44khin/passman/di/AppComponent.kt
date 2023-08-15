package com.s44khin.passman.di

import android.content.Context
import androidx.navigation.NavHostController
import com.s44khin.common.di.CommonModule
import com.s44khin.passman.core.App
import com.s44khin.passman.di.modules.AppViewModelsModule
import com.s44khin.passman.di.modules.DiModule
import com.s44khin.passman.presentation.MainActivity
import com.s44khin.passman.presentation.MainViewModel
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        FeatureDependenciesModule::class,
        DiModule::class,
        CommonModule::class,
        AppViewModelsModule::class
    ]
)
interface AppComponent : AllFeaturesDependencies {

    companion object {

        fun create(
            context: Context,
            navHostController: NavHostController
        ) = DaggerAppComponent
            .builder()
            .bindNavHostController(navHostController)
            .bindContext(context)
            .build()
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        @BindsInstance
        fun bindNavHostController(navHostController: NavHostController): Builder

        fun build(): AppComponent
    }

    fun inject(place: App)

    fun inject(place: MainActivity)

    fun inject(place: MainViewModel)
}
