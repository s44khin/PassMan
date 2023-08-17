package com.s44khin.common.api.core.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<STATE : Any, ACTION>(
    initState: STATE,
) : ViewModel(), ActionHandler<ACTION>, StateStore<STATE> by StateStoreImpl(
    initState = initState
)
