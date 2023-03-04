package com.s44khin.passman.di

import android.content.Context
import androidx.navigation.NavHostController
import com.s44khin.passman.core.MainActivity
import com.s44khin.passman.di.modules.AppModule
import com.s44khin.passman.di.modules.ViewModelsModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        ViewModelsModule::class,
        AppModule::class,
    ]
)
interface AppComponent {

    companion object {
        fun create(context: Context, navHostController: NavHostController): AppComponent {
            return DaggerAppComponent.builder()
                .bind(context)
                .bind(navHostController)
                .build()
        }
    }

    fun inject(place: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bind(context: Context): Builder

        @BindsInstance
        fun bind(navHostController: NavHostController): Builder

        fun build(): AppComponent
    }
}
