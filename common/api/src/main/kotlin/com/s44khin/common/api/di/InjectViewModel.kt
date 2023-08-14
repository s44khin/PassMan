package com.s44khin.common.api.di

import androidx.annotation.MainThread
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@MainThread
@Composable
inline fun <reified VM : ViewModel, T : ViewModelsFeatureComponent> injectViewModel(
    featureComponentFactory: FeatureComponentFactory<T>,
): VM {
    val context = LocalContext.current

    return viewModel(
        factory = FeatureViewModelFactory(
            ComponentStorage
                .bind(context = context, componentFactory = featureComponentFactory)
                .getViewModels(),
        ),
    )
}
