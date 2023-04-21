package com.s44khin.passman.core

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
inline fun <STATE : Any, ACTION : Any, reified VIEW_MODEL> BaseScreen(
    content: @Composable ScreenScope<STATE, ACTION>.() -> Unit
) where VIEW_MODEL : ViewModel, VIEW_MODEL : StateStore<STATE>, VIEW_MODEL : ActionHandler<ACTION> {
    val viewModel: VIEW_MODEL = viewModel(factory = LocalViewModelFactoryProvider.current)

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )

    val coroutineScope = rememberCoroutineScope()

    val state by viewModel.state.collectAsState()

    val scope = remember {
        ScreenScopeImpl(
            state = state,
            sheetState = sheetState,
            onAction = viewModel::onAction,
            onShowSheet = {
                coroutineScope.launch {
                    sheetState.show()
                }
            },
            onHideSheet = {
                coroutineScope.launch {
                    sheetState.hide()
                }
            }
        )
    }

    scope.state = state
    scope.content()
}

@Immutable
@OptIn(ExperimentalMaterialApi::class)
interface ScreenScope<STATE : Any, ACTION : Any> {

    val state: STATE

    val onAction: (ACTION) -> Unit

    val sheetState: ModalBottomSheetState

    fun showSheet()

    fun hideSheet()
}

@Stable
@OptIn(ExperimentalMaterialApi::class)
class ScreenScopeImpl<STATE : Any, ACTION : Any>(
    state: STATE,
    override val sheetState: ModalBottomSheetState,
    override val onAction: (ACTION) -> Unit,
    private val onShowSheet: () -> Unit,
    private val onHideSheet: () -> Unit,
) : ScreenScope<STATE, ACTION> {

    override var state: STATE by mutableStateOf(state)

    override fun showSheet() = onShowSheet()

    override fun hideSheet() = onHideSheet()
}