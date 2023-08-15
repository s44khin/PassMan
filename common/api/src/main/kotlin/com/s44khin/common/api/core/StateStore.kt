package com.s44khin.common.api.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface StateStore<STATE> {

    val state: StateFlow<STATE>

    var viewState: STATE
}

class StateStoreImpl<STATE>(
    initState: STATE,
) : StateStore<STATE> {

    private val _state = MutableStateFlow(initState)

    override val state: StateFlow<STATE> = _state.asStateFlow()

    override var viewState: STATE
        get() = state.value
        set(value) {
            _state.value = value
        }
}