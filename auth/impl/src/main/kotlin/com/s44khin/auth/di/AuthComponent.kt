package com.s44khin.auth.di

import android.content.Context
import com.s44khin.auth.di.dependencies.AuthDependencies
import com.s44khin.auth.di.modules.AuthViewModelModule
import com.s44khin.common.api.di.Feature
import com.s44khin.common.api.di.FeatureComponentFactory
import com.s44khin.common.api.di.ViewModelsFeatureComponent
import com.s44khin.common.api.di.findFeatureDependencies
import dagger.Component

@Feature
@Component(
    modules = [AuthViewModelModule::class],
    dependencies = [AuthDependencies::class]
)
internal interface AuthComponent : ViewModelsFeatureComponent {

    companion object : FeatureComponentFactory<AuthComponent> {

        override fun create(context: Context): AuthComponent {
            return DaggerAuthComponent.builder()
                .authDependencies(context.findFeatureDependencies())
                .build()
        }
    }
}