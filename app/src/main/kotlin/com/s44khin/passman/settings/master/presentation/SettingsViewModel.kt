package com.s44khin.passman.settings.master.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s44khin.passman.core.ActionHandler
import com.s44khin.passman.core.AppRouter
import com.s44khin.passman.core.StateStore
import com.s44khin.passman.core.StateStoreDelegate
import com.s44khin.passman.settings.master.SettingsRepository
import com.s44khin.passman.settings.master.domain.DeleteAllUseCase
import com.s44khin.passman.settings.master.domain.InsertCodesUseCase
import com.s44khin.passman.settings.master.presentation.data.codeMock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val appRouter: AppRouter,
    private val deleteAllUseCase: DeleteAllUseCase,
    private val insertCodesUseCase: InsertCodesUseCase,
    private val settingsRepository: SettingsRepository,
) : ViewModel(), ActionHandler<SettingsAction>, StateStore<SettingsState> by StateStoreDelegate(
    initState = SettingsState(
        showNextCode = settingsRepository.showNextCode,
        showColor = settingsRepository.showColor,
    )
) {

    private val savedState = viewState.copy()

    override fun onAction(action: SettingsAction) = when (action) {
        is SettingsAction.AddDebugData -> addDebugData()
        is SettingsAction.ChangeShowColor -> changeShowColor()
        is SettingsAction.ChangeShowNextCode -> changeShowNextCode()
        is SettingsAction.DeleteAll -> deleteAll()
    }

    private fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllUseCase.execute()
        }
    }

    private fun addDebugData() {
        viewModelScope.launch(Dispatchers.IO) {
            insertCodesUseCase.execute(*codeMock)
        }
    }

    private fun changeShowNextCode() {
        viewState = viewState.changeShowNextCode()
        settingsRepository.showNextCode = !settingsRepository.showNextCode
        viewState = viewState.changeButtonEnabled(buttonEnabled = checkButtonEnabled())
        update()
    }

    private fun changeShowColor() {
        viewState = viewState.changeShowColor()
        settingsRepository.showColor = !settingsRepository.showColor
        viewState = viewState.changeButtonEnabled(buttonEnabled = checkButtonEnabled())
        update()
    }

    private fun checkButtonEnabled(): Boolean = with(viewState) {
        showNextCode != savedState.showNextCode ||
                showColor != savedState.showColor
    }

    private fun update() = viewModelScope.launch(Dispatchers.IO) {
        settingsRepository.postUpdate()
    }
}