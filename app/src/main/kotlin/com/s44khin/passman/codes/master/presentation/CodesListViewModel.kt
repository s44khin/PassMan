package com.s44khin.passman.codes.master.presentation

import androidx.lifecycle.viewModelScope
import com.s44khin.passman.codes.common.Constants
import com.s44khin.passman.codes.master.domain.DeleteCodesUseCase
import com.s44khin.passman.codes.master.domain.GetCodesUseCase
import com.s44khin.passman.codes.master.presentation.data.TotpItemVO
import com.s44khin.passman.codes.navigation.CodesNavigation
import com.s44khin.passman.core.BaseViewModel
import com.s44khin.passman.navigation.ScreenRouter
import com.s44khin.passman.util.filterMap
import com.s44khin.passman.util.infinity
import dev.turingcomplete.kotlinonetimepassword.GoogleAuthenticator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

class CodesListViewModel @Inject constructor(
    private val getCodesUseCase: GetCodesUseCase,
    private val deleteCodesUseCase: DeleteCodesUseCase,
    private val screenRouter: ScreenRouter,
) : BaseViewModel<CodesListState, CodesListAction>(
    initState = CodesListState()
) {

    init {
        screenRouter.onSignal(Constants.UPDATE_CODES_LIST) {
            getData()
        }

        getData()
    }

    override fun onAction(action: CodesListAction) = when (action) {
        is CodesListAction.AddClick -> addClick()
        is CodesListAction.StartEdit -> viewState = viewState.toEdit(action.uid)
        is CodesListAction.StopEdit -> viewState = viewState.stopEdit()
        is CodesListAction.CheckedClick -> viewState = viewState.toChecked(action.uid)
        is CodesListAction.DeleteClick -> deleteClick()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val codes = getCodesUseCase()

            viewState = viewState.toNewList(
                newCodes = codes.map {
                    TotpItemVO(
                        uid = it.uid,
                        name = it.name,
                        secretCode = it.secretCode,
                        nextCode = getCode(it.secretCode, next = true),
                        code = getCode(it.secretCode, next = false),
                        color = it.color,
                        timer = getTimer()
                    )
                }
            )
        }

        updateCodes()
    }

    private fun updateCodes() {
        viewModelScope.infinity(Dispatchers.IO) {
            val timer = getTimer()

            viewState = viewState.toNewList(
                newCodes = viewState.codes.map {
                    it.copy(
                        code = if (timer == 30) getCode(it.secretCode, false) else it.code,
                        nextCode = if (timer == 30) getCode(it.secretCode, true) else it.nextCode,
                        timer = timer,
                    )
                }
            )
        }
    }

    private fun getCode(secretCode: String, next: Boolean): String {
        val timestamp = if (next) Date(System.currentTimeMillis() + 30000) else Date(System.currentTimeMillis())
        return GoogleAuthenticator(secretCode.toByteArray()).generate(timestamp)
    }

    private fun getTimer(): Int {
        var seconds = (System.currentTimeMillis() % 100000) / 1000

        while (seconds >= 30) {
            seconds -= 30
        }

        return 30 - seconds.toInt()
    }

    private fun addClick() {
        screenRouter.navigateTo(CodesNavigation.Add)
    }

    private fun deleteClick() {
        viewModelScope.launch(Dispatchers.IO) {
            val deleteIds = viewState.codes.filterMap(
                predicate = { it.checked },
                transform = { it.uid }
            )

            deleteCodesUseCase(*deleteIds.toTypedArray())

            viewState = viewState.deleteChecked()
        }
    }
}
