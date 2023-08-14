package com.s44khin.passman.di.modules

import com.s44khin.common.api.di.ComponentStorage
import com.s44khin.common.api.di.ComponentStorageImpl
import com.s44khin.passman.di.AppScope
import dagger.Binds
import dagger.Module

@Module
interface DiModule {

    @AppScope
    @Binds
    fun bindComponentStorage(componentStorage: ComponentStorageImpl): ComponentStorage
}
