package dev.s44khin.passman.core.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dev.s44khin.passman.core.base.actionHandler.ActionHandler
import dev.s44khin.passman.core.base.stateStore.StateStore
import dev.s44khin.passman.core.util.LocalNavController
import dev.s44khin.passman.core.util.rememberOnAction

@Composable
inline fun <STATE : Any, ACTION, reified VM, EFFECT : UiEffect> BaseScreen(
    content: @Composable BaseScreenScope<STATE, ACTION, EFFECT>.() -> Unit,
) where VM : ViewModel, VM : ActionHandler<ACTION>, VM : StateStore<STATE>, VM : UiEffectProvider<EFFECT> {
    val viewModel: VM = hiltViewModel()

    val state by viewModel.state.collectAsState()
    val onAction = viewModel.rememberOnAction()
    val navController = LocalNavController.current

    val scope = remember {
        BaseScreenScopeImpl<STATE, ACTION, EFFECT>(
            state = state,
            navController = navController,
            onAction = onAction
        )
    }

    LaunchedEffect(Unit) {
        viewModel.effects.collect {
            scope.onEffect?.invoke(it)
        }
    }

    scope.update(state)

    scope.content()
}

interface BaseScreenScope<STATE : Any, ACTION, EFFECT : UiEffect> {

    val state: STATE
    val onAction: (ACTION) -> Unit
    var onEffect: ((EFFECT) -> Unit)?
    val navController: NavController
}

@Stable
class BaseScreenScopeImpl<STATE : Any, ACTION, EFFECT : UiEffect>(
    state: STATE,
    override val navController: NavController,
    override val onAction: (ACTION) -> Unit,
) : BaseScreenScope<STATE, ACTION, EFFECT> {

    override var state by mutableStateOf(state)

    override var onEffect: ((EFFECT) -> Unit)? = null

    fun update(state: STATE) {
        this.state = state
    }
}