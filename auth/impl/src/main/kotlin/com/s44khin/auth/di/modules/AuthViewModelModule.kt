package com.s44khin.auth.di.modules

import androidx.lifecycle.ViewModel
import com.s44khin.auth.login.LoginViewModel
import com.s44khin.common.api.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
}
