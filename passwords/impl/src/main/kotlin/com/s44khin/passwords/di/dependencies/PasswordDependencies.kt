package com.s44khin.passwords.di.dependencies

import android.content.Context
import com.s44khin.common.api.di.FeatureDependencies
import com.s44khin.common.api.repositories.ContextRepository

interface PasswordDependencies : FeatureDependencies {

    fun getContext(): Context
    fun getContextRepository(): ContextRepository
}