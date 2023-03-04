package com.s44khin.passman.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
inline fun <STATE : Any, ACTION : Any, reified VIEW_MODEL : BaseViewModel<STATE, ACTION>> Screen(
    content: @Composable ScreenScope<STATE, ACTION>.() -> Unit
) {
    val viewModel: VIEW_MODEL = viewModel(factory = LocalViewModelFactoryProvider.current)

    val state by viewModel.state.collectAsState()

    val scope = ScreenScopeImpl(
        state = state,
        onAction = viewModel::onAction
    )

    scope.content()
}

@Immutable
interface ScreenScope<STATE : Any, ACTION : Any> {

    val state: STATE

    val onAction: (ACTION) -> Unit
}

@Immutable
class ScreenScopeImpl<STATE : Any, ACTION : Any>(
    override val state: STATE,
    override val onAction: (ACTION) -> Unit
) : ScreenScope<STATE, ACTION>