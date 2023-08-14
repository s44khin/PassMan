package com.s44khin.passman.di

import com.s44khin.common.api.di.FeatureDependencies
import com.s44khin.passwords.di.dependencies.PasswordDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FeatureDependenciesModule {

    @[Binds IntoMap FeatureDependenciesKey(PasswordDependencies::class)]
    fun bindPasswordDependencies(appComponent: AppComponent): FeatureDependencies
}
