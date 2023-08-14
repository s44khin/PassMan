package com.s44khin.common.api.di

import androidx.lifecycle.ViewModel
import javax.inject.Provider

interface ViewModelsFeatureComponent : FeatureComponent {
    fun getViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
}
