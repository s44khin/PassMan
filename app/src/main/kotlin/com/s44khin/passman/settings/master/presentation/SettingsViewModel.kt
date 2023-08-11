package com.s44khin.passman.settings.master.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s44khin.passman.core.ActionHandler
import com.s44khin.passman.core.StateStore
import com.s44khin.passman.core.StateStoreDelegate
import com.s44khin.passman.settings.master.SettingsRepository
import com.s44khin.passman.settings.master.domain.DeleteAllUseCase
import com.s44khin.passman.settings.master.domain.InsertCodesUseCase
import com.s44khin.passman.settings.master.presentation.data.StartScreen
import com.s44khin.passman.settings.master.presentation.data.ThemeMode
import com.s44khin.passman.settings.master.presentation.data.codeMock
import com.s44khin.uikit.theme.PrimaryColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val deleteAllUseCase: DeleteAllUseCase,
    private val insertCodesUseCase: InsertCodesUseCase,
    private val settingsRepository: SettingsRepository,
) : ViewModel(), ActionHandler<SettingsAction>, StateStore<SettingsState> by StateStoreDelegate(
    initState = SettingsState(
        showNextCode = settingsRepository.showNextCode,
        showColor = settingsRepository.showColor,
        alwaysShowLabel = settingsRepository.showLabel,
        themeMode = settingsRepository.theme,
        showAccount = settingsRepository.showAccount,
        color = settingsRepository.primaryColor,
        startScreen = settingsRepository.startScreen,
    )
) {

    override fun onAction(action: SettingsAction) = when (action) {
        is SettingsAction.AddDebugData -> addDebugData()
        is SettingsAction.ChangeColor -> onChangeColor(action.newColor)
        is SettingsAction.ChangeShowAccount -> onChangeShowAccount()
        is SettingsAction.ChangeShowColor -> changeShowColor()
        is SettingsAction.ChangeShowLabel -> changeShowLabel()
        is SettingsAction.ChangeShowNextCode -> changeShowNextCode()
        is SettingsAction.DeleteAll -> deleteAll()
        is SettingsAction.OnCodesScreenClick -> onCodesScreenClick()
        is SettingsAction.OnDarkThemeClick -> onDarkThemeClick()
        is SettingsAction.OnLightThemeClick -> onLightThemeClick()
        is SettingsAction.OnPasswordsScreenClick -> onPasswordScreenClick()
        is SettingsAction.OnSystemThemeClick -> onSystemThemeClick()
    }

    private fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllUseCase.execute()
            updateData()
        }
    }

    private fun addDebugData() {
        viewModelScope.launch(Dispatchers.IO) {
            insertCodesUseCase.execute(*codeMock)
            updateData()
        }
    }

    private fun changeShowNextCode() {
        viewState = viewState.changeShowNextCode()
        settingsRepository.showNextCode = !settingsRepository.showNextCode

        updateSettings()
    }

    private fun changeShowColor() {
        viewState = viewState.changeShowColor()
        settingsRepository.showColor = !settingsRepository.showColor

        updateSettings()
    }

    private fun changeShowLabel() {
        viewState = viewState.changeShowLabel()
        settingsRepository.showLabel = !settingsRepository.showLabel

        updateSettings()
    }

    private fun onChangeShowAccount() {
        viewState = viewState.changeShowAccount()
        settingsRepository.showAccount = !settingsRepository.showAccount

        updateSettings()
    }

    private fun updateSettings() = viewModelScope.launch(Dispatchers.IO) {
        settingsRepository.postUpdate()
    }

    private fun updateData() = viewModelScope.launch(Dispatchers.IO) {
        settingsRepository.postUpdateData()
    }

    private fun onSystemThemeClick() {
        viewState = viewState.toSystemTheme()
        settingsRepository.theme = ThemeMode.System

        updateSettings()
    }

    private fun onLightThemeClick() {
        viewState = viewState.toLightTheme()
        settingsRepository.theme = ThemeMode.Light

        updateSettings()
    }

    private fun onDarkThemeClick() {
        viewState = viewState.toDarkTheme()
        settingsRepository.theme = ThemeMode.Dark

        updateSettings()
    }

    private fun onChangeColor(newColor: PrimaryColor) {
        viewState = viewState.toNewColor(newColor)
        settingsRepository.primaryColor = newColor

        updateSettings()
    }

    private fun onCodesScreenClick() {
        viewState = viewState.toCodesStartScreen()
        settingsRepository.startScreen = StartScreen.Codes

        updateSettings()
    }

    private fun onPasswordScreenClick() {
        viewState = viewState.toPasswordsStartScreen()
        settingsRepository.startScreen = StartScreen.Passwords

        updateSettings()
    }
}