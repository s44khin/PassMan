package com.s44khin.passman.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface StateStore<STATE : Any> {

    val state: StateFlow<STATE>

    var viewState: STATE
}

class StateStoreDelegate<STATE : Any>(
    initState: STATE
) : StateStore<STATE> {

    private val _state = MutableStateFlow(initState)
    override val state = _state.asStateFlow()
    override var viewState by viewStateFlow(_state, initState)
}
