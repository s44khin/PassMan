package com.s44khin.passwords.di.dependencies

import android.content.Context
import com.s44khin.common.api.di.FeatureDependencies

interface PasswordDependencies : FeatureDependencies {

    fun getContext(): Context
}