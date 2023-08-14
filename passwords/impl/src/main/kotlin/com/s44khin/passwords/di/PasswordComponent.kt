package com.s44khin.passwords.di

import android.content.Context
import com.s44khin.common.api.di.Feature
import com.s44khin.common.api.di.FeatureComponentFactory
import com.s44khin.common.api.di.ViewModelsFeatureComponent
import com.s44khin.common.api.di.findFeatureDependencies
import com.s44khin.passwords.di.dependencies.PasswordDependencies
import com.s44khin.passwords.di.modules.PasswordViewModelModule
import dagger.Component

@Feature
@Component(
    modules = [PasswordViewModelModule::class],
    dependencies = [PasswordDependencies::class]
)
internal interface PasswordComponent : ViewModelsFeatureComponent {

    companion object : FeatureComponentFactory<PasswordComponent> {

        override fun create(context: Context): PasswordComponent {
            return DaggerPasswordComponent.builder()
                .passwordDependencies(context.findFeatureDependencies())
                .build()
        }
    }
}