package com.s44khin.common.di

import com.s44khin.common.api.repositories.ContextRepository
import com.s44khin.common.repositories.ContextRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface CommonModule {

    @Binds
    fun bindContextRepository(contextRepository: ContextRepositoryImpl): ContextRepository
}
