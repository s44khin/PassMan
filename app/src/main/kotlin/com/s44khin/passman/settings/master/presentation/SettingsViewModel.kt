package com.s44khin.passman.settings.master.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s44khin.passman.common.Constants
import com.s44khin.passman.core.ActionHandler
import com.s44khin.passman.core.AppRouter
import com.s44khin.passman.core.AppStorage
import com.s44khin.passman.core.StateStore
import com.s44khin.passman.core.StateStoreDelegate
import com.s44khin.passman.settings.master.domain.DeleteAllUseCase
import com.s44khin.passman.settings.master.domain.InsertCodesUseCase
import com.s44khin.passman.settings.master.presentation.data.codeMock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val appRouter: AppRouter,
    private val appStorage: AppStorage,
    private val deleteAllUseCase: DeleteAllUseCase,
    private val insertCodesUseCase: InsertCodesUseCase,
) : ViewModel(), ActionHandler<SettingsAction>, StateStore<SettingsState> by StateStoreDelegate(
    initState = SettingsState(
        showNextCode = appStorage.getBoolean(key = Constants.SHOW_NEXT_CODE_KEY, defaultValue = true)
    )
) {

    private val savedState = viewState.copy()

    override fun onAction(action: SettingsAction) = when (action) {
        is SettingsAction.AddDebugData -> addDebugData()
        is SettingsAction.DeleteAll -> deleteAll()
        is SettingsAction.ChangeShowNextCode -> changeShowNextCode()
        is SettingsAction.Restart -> restart()
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
        appStorage.putBoolean(key = Constants.SHOW_NEXT_CODE_KEY, value = viewState.showNextCode)
        viewState = viewState.changeButtonEnabled(buttonEnabled = checkButtonEnabled())
    }

    private fun checkButtonEnabled(): Boolean = with(viewState) {
        showNextCode != savedState.showNextCode
    }

    private fun restart() {
        appRouter.restart()
    }
}