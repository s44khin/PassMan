package com.s44khin.passman.settings.master

import com.s44khin.passman.core.AppStorage
import com.s44khin.passman.di.AppScope
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
    }

    private val _events = MutableSharedFlow<SettingsEvents>()
    val events = _events.asSharedFlow()

    var showNextCode: Boolean
        get() = appStorage.getBoolean(key = SHOW_NEXT_CODE_KEY, defaultValue = false)
        set(value) = appStorage.putBoolean(key = SHOW_NEXT_CODE_KEY, value = value)

    var showColor: Boolean
        get() = appStorage.getBoolean(key = SHOW_COLOR_KEY, defaultValue = true)
        set(value) = appStorage.putBoolean(key = SHOW_COLOR_KEY, value = value)

    suspend fun postUpdate() {
        _events.emit(value = SettingsEvents.UPDATE)
    }

    enum class SettingsEvents {
        UPDATE
    }
}