package com.s44khin.passman.codes.master.presentation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.codes.master.presentation.widgets.AddDialog
import com.s44khin.passman.codes.master.presentation.widgets.CodesList
import com.s44khin.passman.core.Screen
import com.s44khin.uikit.util.BottomSheetWrapper
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CodesListScreen() = Screen<CodesListState, CodesListAction, CodesListViewModel> {
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true,
    )

    val coroutineScope = rememberCoroutineScope()

    BottomSheetWrapper(
        sheetState = bottomSheetState,
        title = stringResource(R.string.codes_add_new_code_label),
        bottomSheetContent = {
            AddDialog(
                qrCode = {
                    coroutineScope.launch { bottomSheetState.hide() }
                },
                manually = {
                    onAction(CodesListAction.AddClick)
                    coroutineScope.launch { bottomSheetState.hide() }
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


