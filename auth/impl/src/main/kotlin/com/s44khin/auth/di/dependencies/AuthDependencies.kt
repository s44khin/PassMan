package com.s44khin.auth.di.dependencies

import com.s44khin.common.api.di.FeatureDependencies
import com.s44khin.common.api.navigation.ScreenRouter
import com.s44khin.common.api.repositories.UserRepository

interface AuthDependencies : FeatureDependencies {

    fun getScreenRouter(): ScreenRouter
    fun getUserRepository(): UserRepository
}
