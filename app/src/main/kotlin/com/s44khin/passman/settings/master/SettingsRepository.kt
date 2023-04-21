package com.s44khin.passman.settings.master

import com.s44khin.passman.core.AppStorage
import com.s44khin.passman.di.AppScope
import com.s44khin.passman.settings.master.presentation.data.ThemeMode
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@AppScope
class SettingsRepository @Inject constructor(
    private val appStorage: AppStorage,
) {

    private companion object {
        const val SHOW_NEXT_CODE_KEY = "show_next_code_key"
        const val SHOW_COLOR_KEY = "show_color_key"
        const val SHOW_LABEL_KEY = "show_label_key"
        const val THEME_KEY = "theme_key"
        const val SHOW_ACCOUNT_KEY = "SHOW_ACCOUNT_KEY"
    }

    private val _events = MutableSharedFlow<SettingsEvents>()
    val events = _events.asSharedFlow()

    var showNextCode: Boolean
        get() = appStorage.getBoolean(key = SHOW_NEXT_CODE_KEY, defaultValue = false)
        set(value) = appStorage.putBoolean(key = SHOW_NEXT_CODE_KEY, value = value)

    var showColor: Boolean
        get() = appStorage.getBoolean(key = SHOW_COLOR_KEY, defaultValue = true)
        set(value) = appStorage.putBoolean(key = SHOW_COLOR_KEY, value = value)

    var showLabel: Boolean
        get() = appStorage.getBoolean(key = SHOW_LABEL_KEY, defaultValue = false)
        set(value) = appStorage.putBoolean(key = SHOW_LABEL_KEY, value = value)

    var showAccount: Boolean
        get() = appStorage.getBoolean(key = SHOW_ACCOUNT_KEY, defaultValue = true)
        set(value) = appStorage.putBoolean(key = SHOW_ACCOUNT_KEY, value = value)

    var theme: ThemeMode
        get() = ThemeMode.valueOf(appStorage.getString(key = THEME_KEY, defaultValue = ThemeMode.System.name))
        set(value) = appStorage.putString(key = THEME_KEY, value = value.name)

    suspend fun postUpdate() {
        _events.emit(value = SettingsEvents.UPDATE)
    }

    suspend fun postUpdateData() {
        _events.emit(value = SettingsEvents.UPDATE_DATA)
    }

    enum class SettingsEvents {
        UPDATE, UPDATE_DATA
    }
}