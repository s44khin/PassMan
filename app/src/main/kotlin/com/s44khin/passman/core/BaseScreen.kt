package com.s44khin.passman.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
inline fun <STATE : Any, ACTION : Any, reified VIEW_MODEL> BaseScreen(
    content: @Composable ScreenScope<STATE, ACTION>.() -> Unit
) where VIEW_MODEL : ViewModel, VIEW_MODEL : StateStore<STATE>, VIEW_MODEL : ActionHandler<ACTION> {
    val viewModel: VIEW_MODEL = viewModel(factory = LocalViewModelFactoryProvider.current)

    val state by viewModel.state.collectAsState()

    val scope = remember {
        ScreenScopeImpl(
            state = state,
            onAction = viewModel::onAction,
        )
    }

    scope.state = state
    scope.content()
}

@Stable
interface ScreenScope<STATE : Any, ACTION : Any> {

    val state: STATE

    val onAction: (ACTION) -> Unit
}

@Stable
class ScreenScopeImpl<STATE : Any, ACTION : Any>(
    state: STATE,
    override val onAction: (ACTION) -> Unit,
) : ScreenScope<STATE, ACTION> {

    override var state: STATE by mutableStateOf(state)
}