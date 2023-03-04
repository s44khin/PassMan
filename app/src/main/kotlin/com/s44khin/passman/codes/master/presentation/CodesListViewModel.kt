package com.s44khin.passman.codes.master.presentation

import com.s44khin.passman.core.BaseViewModel
import javax.inject.Inject

class CodesListViewModel @Inject constructor() : BaseViewModel<CodesListViewState, CodesListAction>(
    initState = CodesListViewState()
) {

    override fun onAction(action: CodesListAction) = when (action) {
        is CodesListAction.TextClick -> viewState = viewState.copy(text = "1")
    }
}
