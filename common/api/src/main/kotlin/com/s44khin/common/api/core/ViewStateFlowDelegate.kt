package com.s44khin.common.api.core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

fun <STATE : Any> viewStateFlow(
    flow: MutableStateFlow<STATE>,
    initState: STATE
): ObservableProperty<STATE> = ViewStateFlowDelegate(
    flow = flow,
    initState = initState
)

private class ViewStateFlowDelegate<STATE : Any>(
    private val flow: MutableStateFlow<STATE>,
    initState: STATE,
) : ObservableProperty<STATE>(initState) {

    override fun afterChange(property: KProperty<*>, oldValue: STATE, newValue: STATE) {
        flow.value = newValue
    }
}
