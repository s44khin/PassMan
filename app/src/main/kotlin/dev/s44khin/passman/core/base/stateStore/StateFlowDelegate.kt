package dev.s44khin.passman.core.base.stateStore

import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

class StateFlowDelegate<STATE : Any>(
    private val flow: MutableStateFlow<STATE>,
    initState: STATE,
) : ObservableProperty<STATE>(initState) {

    override fun afterChange(property: KProperty<*>, oldValue: STATE, newValue: STATE) {
        flow.value = newValue
    }
}
