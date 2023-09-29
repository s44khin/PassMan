package dev.s44khin.passman.core.base.stateStore

import kotlinx.coroutines.flow.MutableStateFlow

class StateStoreImpl<STATE : Any>(initState: STATE) : StateStore<STATE> {

    override val state = MutableStateFlow(initState)
    override var viewState by StateFlowDelegate(
        flow = state,
        initState = initState
    )
}