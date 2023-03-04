package com.s44khin.passman.di.modules

import androidx.lifecycle.ViewModel
import com.s44khin.passman.codes.master.presentation.CodesListViewModel
import com.s44khin.passman.di.keys.ViewModelKey
import com.s44khin.passman.settings.master.presentation.SettingsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(CodesListViewModel::class)
    fun bindCodesListViewModel(viewModel: CodesListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    fun bindSettingsViewModel(viewModel: SettingsViewModel): ViewModel
}