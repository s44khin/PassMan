package com.s44khin.common.di

import com.s44khin.common.api.navigation.ScreenRouter
import com.s44khin.common.api.repositories.ContextRepository
import com.s44khin.common.navigation.ScreenRouterImpl
import com.s44khin.common.repositories.ContextRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface CommonModule {

    @Binds
    fun bindContextRepository(contextRepository: ContextRepositoryImpl): ContextRepository

    @Binds
    fun bindScreenRouter(screenRouterImpl: ScreenRouterImpl): ScreenRouter
}
