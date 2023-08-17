package com.s44khin.common.api.core.base.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.s44khin.common.api.core.base.ActionHandler
import com.s44khin.common.api.core.base.StateStore

@Composable
inline fun <STATE : Any, ACTION, VM> Screen(
    viewModel: VM,
    content: @Composable ScreenScope<STATE, ACTION>.() -> Unit,
) where VM : ActionHandler<ACTION>, VM : StateStore<STATE> {
    val viewState: State<STATE> = viewModel.state.collectAsState()

    val scope = remember {
        ScreenScopeImpl(
            viewState = viewState,
            onAction = viewModel::onAction
        )
    }

    scope.content()
}

@Immutable
class ScreenScopeImpl<STATE : Any, ACTION>(
    viewState: State<STATE>,
    override val onAction: (ACTION) -> Unit,
) : ScreenScope<STATE, ACTION> {

    override val viewState: STATE by viewState
}

