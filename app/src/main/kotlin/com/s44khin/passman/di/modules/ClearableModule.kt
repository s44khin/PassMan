package com.s44khin.passman.di.modules

import com.s44khin.passman.codes.add.presentation.data.AddCodeArgsRamCache
import com.s44khin.passman.core.Clearable
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface ClearableModule {

    @Binds
    @IntoSet
    fun bindsAddCodeArgsRamCache(cache: AddCodeArgsRamCache): Clearable
}
