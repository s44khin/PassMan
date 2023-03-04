package com.s44khin.passman.di.modules

import android.content.Context
import androidx.lifecycle.ViewModel
import com.s44khin.passman.core.AppStorage
import com.s44khin.passman.core.AppViewModelFactory
import com.s44khin.passman.di.AppScope
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class AppModule {

    companion object {
        private const val SETTINGS = "settings"
    }

    @AppScope
    @Provides
    fun provideAppVieModelFactory(
        creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): AppViewModelFactory {
        return AppViewModelFactory(creators)
    }

    @AppScope
    @Provides
    fun provideAppStorage(context: Context) = AppStorage(
        sharedPreferences = context.getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)
    )
}