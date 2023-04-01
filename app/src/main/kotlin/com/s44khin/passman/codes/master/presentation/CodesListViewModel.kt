package com.s44khin.passman.codes.master.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s44khin.passman.codes.master.domain.DeleteCodesUseCase
import com.s44khin.passman.codes.master.domain.GetCodesUseCase
import com.s44khin.passman.codes.master.presentation.data.TotpItemVO
import com.s44khin.passman.codes.navigation.CodesNavigation
import com.s44khin.passman.common.Constants
import com.s44khin.passman.common.TotpHelper
import com.s44khin.passman.core.ActionHandler
import com.s44khin.passman.core.AppRouter
import com.s44khin.passman.core.AppStorage
import com.s44khin.passman.core.StateStore
import com.s44khin.passman.core.StateStoreDelegate
import com.s44khin.passman.navigation.ScreenRouter
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
    private val totpHelper: TotpHelper,
    appStorage: AppStorage,
) : ViewModel(), ActionHandler<CodesListAction>, StateStore<CodesListState> by StateStoreDelegate(
    initState = CodesListState(
        showNextCode = appStorage.getBoolean(key = Constants.SHOW_NEXT_CODE_KEY, defaultValue = true)
    )
) {

    private var updateJob: Job? = null

    init {
        screenRouter.onSignal(Constants.UPDATE_CODES_LIST) {
            getData()
        }

        getData()
    }

    override fun onAction(action: CodesListAction) = when (action) {
        is CodesListAction.ManuallyClick -> manuallyClick()
        is CodesListAction.CheckedClick -> viewState = viewState.toChecked(action.uid)
        is CodesListAction.CopyToClipboard -> appRouter.copyToClipboard(action.code)
        is CodesListAction.DeleteClick -> deleteClick()
        is CodesListAction.StartEdit -> viewState = viewState.toEdit(action.uid)
        is CodesListAction.StopEdit -> viewState = viewState.stopEdit()
        is CodesListAction.QrCodeClick -> qrCodeClick()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val codes = getCodesUseCase.execute()

            viewState = viewState.toNewList(
                newCodes = codes.map {
                    TotpItemVO(
                        uid = it.uid,
                        name = it.name,
                        secretCode = it.secretCode,
                        nextCode = totpHelper.getCurrentCode(it.secretCode),
                        code = totpHelper.getNextCode(it.secretCode, it.updateTimer),
                        color = it.color,
                        timer = totpHelper.getTimer(it.updateTimer),
                        account = it.account,
                        updateTimer = it.updateTimer,
                    )
                }
            )
        }

        updateJob?.cancel()
        updateJob = updateCodes()
    }

    private fun updateCodes() = viewModelScope.infinity(Dispatchers.IO) {
        viewState = viewState.toNewList(
            newCodes = viewState.codes.map {
                val timer = totpHelper.getTimer(it.updateTimer)

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
    }

    private fun qrCodeClick() {
        screenRouter.navigateTo(CodesNavigation.Scanner)
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
}
