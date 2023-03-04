package com.s44khin.passman.di.modules

import androidx.lifecycle.ViewModel
import com.s44khin.passman.core.AppViewModelFactory
import com.s44khin.passman.di.AppScope
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class AppModule {

    @AppScope
    @Provides
    fun provideAppVieModelFactory(
        creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): AppViewModelFactory {
        return AppViewModelFactory(creators)
    }
}