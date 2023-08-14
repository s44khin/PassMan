package com.s44khin.passwords.di.modules

import androidx.lifecycle.ViewModel
import com.s44khin.common.api.di.ViewModelKey
import com.s44khin.passwords.list.master.PasswordsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface PasswordViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PasswordsListViewModel::class)
    fun bindPasswordsListViewModel(viewModel: PasswordsListViewModel): ViewModel
}
