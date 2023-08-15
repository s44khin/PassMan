package com.s44khin.common.repositories

import android.content.Context
import com.s44khin.common.api.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val context: Context
) : UserRepository {

    private companion object {
        const val PREF_NAME = "user_settigns"
        const val IS_LOGGED_KEY = "is_logged"
    }

    private val sharedPreferences by lazy {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    override var isLogged: Boolean
        get() = sharedPreferences.getBoolean(IS_LOGGED_KEY, false)
        set(value) {
            sharedPreferences.edit()
                .putBoolean(IS_LOGGED_KEY, value)
                .apply()
        }
}