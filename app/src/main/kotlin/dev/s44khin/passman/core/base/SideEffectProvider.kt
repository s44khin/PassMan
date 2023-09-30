package dev.s44khin.passman.core.base

import androidx.compose.runtime.Immutable
import dev.s44khin.passman.core.util.UID
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

interface SideEffectProvider<EFFECT : AppSideEffect> {

    val effects: SharedFlow<EFFECT>

    suspend fun onEffect(effect: EFFECT)
}

class SideEffectProviderImpl<EFFECT : AppSideEffect> : SideEffectProvider<EFFECT> {

    private val _effects = MutableSharedFlow<EFFECT>()
    override val effects: SharedFlow<EFFECT> = _effects.asSharedFlow()

    override suspend fun onEffect(effect: EFFECT) {
        _effects.emit(effect)
    }
}

@Immutable
open class AppSideEffect {

    val uid: UID = UID.randomUID()
}
