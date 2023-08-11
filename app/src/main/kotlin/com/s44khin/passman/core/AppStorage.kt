package com.s44khin.passman.core

import android.content.SharedPreferences

class AppStorage(private val sharedPreferences: SharedPreferences) {

    fun putBoolean(key: String, value: Boolean) = sharedPreferences.edit()
        .putBoolean(key, value)
        .apply()

    fun putString(key: String, value: String) = sharedPreferences.edit()
        .putString(key, value)
        .apply()

    fun getBoolean(key: String, defaultValue: Boolean) = sharedPreferences.getBoolean(key, defaultValue)

    fun getString(key: String, defaultValue: String) = sharedPreferences.getString(key, defaultValue)!!
}
