package dev.s44khin.passman.core.base

import androidx.lifecycle.ViewModel
import dev.s44khin.passman.core.base.actionHandler.ActionHandler
import dev.s44khin.passman.core.base.stateStore.StateStore
import dev.s44khin.passman.core.base.stateStore.StateStoreImpl

abstract class BaseViewModel<STATE : Any, ACTION, EFFECT : AppSideEffect>(
    initState: STATE
) : ViewModel(), ActionHandler<ACTION>, StateStore<STATE> by StateStoreImpl(
    initState = initState
), SideEffectProvider<EFFECT> by SideEffectProviderImpl()

