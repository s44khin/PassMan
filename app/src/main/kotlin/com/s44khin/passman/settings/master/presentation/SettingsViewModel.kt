package com.s44khin.passman.settings.master.presentation

import com.s44khin.passman.core.AppStorage
import com.s44khin.passman.core.BaseViewModel
import com.s44khin.passman.settings.master.presentation.data.ThemeVO
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val appStorage: AppStorage,
) : BaseViewModel<SettingsState, SettingsAction>(
    initState = SettingsState()
) {

    companion object {
        const val THEME_KEY = "theme_key"
    }

    init {
        viewState = viewState.changeTheme(
            newTheme = ThemeVO.valueOf(
                appStorage.getString(key = THEME_KEY, defaultValue = ThemeVO.System.name)
            )
        )
    }

    override fun onAction(action: SettingsAction) = when (action) {
        is SettingsAction.ChangeTheme -> changeTheme(action.theme)
    }

    private fun changeTheme(theme: ThemeVO) {
        appStorage.putString(key = THEME_KEY, value = theme.name)
        viewState = viewState.changeTheme(theme)
    }
}