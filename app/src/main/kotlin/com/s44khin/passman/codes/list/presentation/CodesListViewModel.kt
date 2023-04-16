package com.s44khin.passman.codes.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s44khin.passman.codes.list.domain.ChangePinnedCodesUseCase
import com.s44khin.passman.codes.list.domain.DeleteCodesUseCase
import com.s44khin.passman.codes.list.domain.GetCodesUseCase
import com.s44khin.passman.codes.list.presentation.data.TotpItemVO
import com.s44khin.passman.codes.navigation.CodesNavigation
import com.s44khin.passman.common.Constants
import com.s44khin.passman.common.TotpHelper
import com.s44khin.passman.core.ActionHandler
import com.s44khin.passman.core.AppRouter
import com.s44khin.passman.core.StateStore
import com.s44khin.passman.core.StateStoreDelegate
import com.s44khin.passman.navigation.ScreenRouter
import com.s44khin.passman.settings.master.SettingsRepository
import com.s44khin.passman.util.filterMap
import com.s44khin.passman.util.infinity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class CodesListViewModel @Inject constructor(
    private val appRouter: AppRouter,
    private val deleteCodesUseCase: DeleteCodesUseCase,
    private val getCodesUseCase: GetCodesUseCase,
    private val screenRouter: ScreenRouter,
    private val settingsRepository: SettingsRepository,
    private val totpHelper: TotpHelper,
    private val changePinnedCodesUseCase: ChangePinnedCodesUseCase,
) : ViewModel(), ActionHandler<CodesListAction>, StateStore<CodesListState> by StateStoreDelegate(
    initState = CodesListState(
        showNextCode = settingsRepository.showNextCode,
        showColor = settingsRepository.showColor
    )
) {

    private var updateJob: Job? = null

    init {
        subscribeToNavSignals()
        subscribeToSettingsUpdate()

        getData()
        updateSettings()
    }

    override fun onAction(action: CodesListAction) = when (action) {
        is CodesListAction.ManuallyClick -> manuallyClick()
        is CodesListAction.CheckedClick -> viewState = viewState.toChecked(action.uid)
        is CodesListAction.CopyToClipboard -> appRouter.copyToClipboard(action.code)
        is CodesListAction.DeleteClick -> deleteClick()
        is CodesListAction.StartEdit -> viewState = viewState.toEdit(action.uid)
        is CodesListAction.StopEdit -> viewState = viewState.stopEdit()
        is CodesListAction.QrCodeClick -> qrCodeClick()
        is CodesListAction.PinClick -> pinClick()
        is CodesListAction.OnAddClick -> viewState = viewState.toAddEnabled()
        is CodesListAction.OnAddDisabled -> viewState = viewState.stopAdd()
    }

    private fun getData() {
        viewState = viewState.toLoading()

        viewModelScope.launch(Dispatchers.IO) {
            val codes = getCodesUseCase.execute()

            if (codes.isNotEmpty()) {
                viewState = viewState
                    .toNewList(
                        newCodes = codes.map {
                            TotpItemVO(
                                uid = it.uid,
                                name = it.name,
                                secretCode = it.secretCode,
                                nextCode = totpHelper.getNextCode(it.secretCode, it.updateTimer),
                                code = totpHelper.getCurrentCode(it.secretCode),
                                color = it.color,
                                timer = totpHelper.getTimer2(it.updateTimer),
                                account = it.account,
                                updateTimer = it.updateTimer,
                                pinned = it.pinned,
                            )
                        }.sortedBy { !it.pinned }
                    )
                    .toContent()

                updateJob?.cancel()
                updateJob = updateCodes()
            } else {
                updateJob = null
                viewState = viewState.toEmpty()
            }
        }
    }

    private fun updateCodes() = viewModelScope.infinity(Dispatchers.IO) {
        viewState = viewState.toNewList(
            newCodes = viewState.codes.map {
                val timer = totpHelper.getTimer2(it.updateTimer)

                it.copy(
                    code = if (timer == it.updateTimer) {
                        totpHelper.getCurrentCode(it.secretCode)
                    } else {
                        it.code
                    },
                    nextCode = if (timer == it.updateTimer) {
                        totpHelper.getNextCode(it.secretCode, it.updateTimer)
                    } else {
                        it.nextCode
                    },
                    timer = timer,
                )
            }
        )
    }

    private fun manuallyClick() {
        screenRouter.navigateTo(CodesNavigation.Add)
        viewState = viewState.stopAdd()
    }

    private fun qrCodeClick() {
        screenRouter.navigateTo(CodesNavigation.Scanner)
        viewState = viewState.stopAdd()
    }

    private fun deleteClick() {
        viewModelScope.launch(Dispatchers.IO) {
            val deleteIds = viewState.codes.filterMap(
                predicate = { it.checked },
                transform = { it.uid }
            )

            deleteCodesUseCase.execute(*deleteIds.toTypedArray())

            viewState = viewState.deleteChecked()
        }
    }

    private fun subscribeToNavSignals() {
        screenRouter.onSignal(Constants.UPDATE_CODES_LIST) {
            getData()
        }
    }

    private fun subscribeToSettingsUpdate() = viewModelScope.launch(Dispatchers.IO) {
        settingsRepository.events.collect { event ->
            when (event) {
                SettingsRepository.SettingsEvents.UPDATE -> updateSettings()
                SettingsRepository.SettingsEvents.UPDATE_DATA -> getData()
            }
        }
    }

    private fun updateSettings() {
        viewState = viewState.copy(
            showColor = settingsRepository.showColor,
            showNextCode = settingsRepository.showNextCode,
        )
    }

    private fun pinClick() {
        viewModelScope.launch(Dispatchers.IO) {
            val pinnedIds = viewState.codes.filterMap(
                predicate = { it.checked },
                transform = { it.uid }
            )

            changePinnedCodesUseCase.execute(*pinnedIds.toTypedArray())
            getData()
            viewState = viewState.stopEdit()
        }
    }
}
