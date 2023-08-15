package com.s44khin.passman.di.modules

import androidx.lifecycle.ViewModel
import com.s44khin.common.api.di.ViewModelKey
import com.s44khin.passman.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface AppViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
