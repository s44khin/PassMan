package com.s44khin.common.api.core.base

import com.s44khin.common.api.core.viewStateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface StateStore<STATE : Any> {

    val state: StateFlow<STATE>

    var viewState: STATE
}

class StateStoreImpl<STATE : Any>(
    initState: STATE,
) : StateStore<STATE> {

    private val _state = MutableStateFlow(initState)
    override val state: StateFlow<STATE> = _state.asStateFlow()
    override var viewState by viewStateFlow(_state, initState)
}