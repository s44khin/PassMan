package com.s44khin.passwords.di.dependencies

import com.s44khin.common.api.di.FeatureDependencies
import com.s44khin.common.api.navigation.ScreenRouter

interface PasswordDependencies : FeatureDependencies {

    fun getScreenRouter(): ScreenRouter
}