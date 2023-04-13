package com.s44khin.passman.codes.list.presentation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.codes.list.presentation.widgets.AddDialog
import com.s44khin.passman.codes.list.presentation.widgets.CodesList
import com.s44khin.passman.core.BaseScreen
import com.s44khin.uikit.util.BottomSheetWrapper
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CodesListScreen() = BaseScreen<CodesListState, CodesListAction, CodesListViewModel> {
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = false
    )

    val coroutineScope = rememberCoroutineScope()

    BottomSheetWrapper(
        sheetState = bottomSheetState,
        title = stringResource(R.string.codes_add_new_code_label),
        bottomSheetContent = {
            AddDialog(
                qrCode = {
                    coroutineScope.launch {
                        bottomSheetState.hide()
                        onAction(CodesListAction.QrCodeClick)
                    }
                },
                manually = {
                    coroutineScope.launch {
                        bottomSheetState.hide()
                        onAction(CodesListAction.ManuallyClick)
                    }
                }
            )
        },
        content = {
            CodesList(
                state = state,
                onAddClick = { coroutineScope.launch { bottomSheetState.show() } },
                onAction = onAction,
            )
        }
    )
}


