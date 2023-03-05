package com.s44khin.passman.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<STATE : Any, ACTION : Any>(initState: STATE) : ViewModel() {

    private val _state: MutableStateFlow<STATE> = MutableStateFlow(initState)
    protected var viewState by viewStateFlow(_state, initState)
    val state = _state.asStateFlow()

    abstract fun onAction(action: ACTION)
}
