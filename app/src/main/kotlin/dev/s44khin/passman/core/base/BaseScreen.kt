package dev.s44khin.passman.core.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import dev.s44khin.passman.core.util.LocalNavController
import dev.s44khin.passman.core.util.rememberOnAction

@Composable
inline fun <STATE : Any, ACTION, EFFECT : AppSideEffect> BaseScreen(
    factory: @Composable () -> BaseViewModel<STATE, ACTION, EFFECT>,
    content: @Composable BaseScreenScope<STATE, ACTION, EFFECT>.() -> Unit,
) {
    val viewModel = factory()

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

interface BaseScreenScope<STATE : Any, ACTION, EFFECT : AppSideEffect> {

    val state: STATE
    val onAction: (ACTION) -> Unit
    var onEffect: ((EFFECT) -> Unit)?
    val navController: NavController
}

@Stable
class BaseScreenScopeImpl<STATE : Any, ACTION, EFFECT : AppSideEffect>(
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