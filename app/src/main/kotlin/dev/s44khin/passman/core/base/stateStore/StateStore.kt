package dev.s44khin.passman.core.base.stateStore

import kotlinx.coroutines.flow.StateFlow

interface StateStore<STATE : Any> {

    val state: StateFlow<STATE>
    var viewState: STATE
}
