package com.s44khin.passman.codes.add.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.data.isNotEmpty
import com.s44khin.passman.codes.add.presentation.widgets.AddCodeContent
import com.s44khin.passman.common.presentation.confirmDialog.ConfirmDialog
import com.s44khin.passman.common.presentation.confirmDialog.ConfirmDialogButton
import com.s44khin.passman.core.BaseScreen
import com.s44khin.uikit.util.BottomSheetWrapper
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddCodeScreen() = BaseScreen<AddCodeState, AddCodeAction, AddCodeViewModel> {
    val coroutineScope = rememberCoroutineScope()

    BackHandler(enabled = state.isNotEmpty) {
        if (sheetState.isVisible) {
            hideSheet()
        } else {
            showSheet()
        }
    }

    BottomSheetWrapper(
        modifier = Modifier.imePadding(),
        title = stringResource(R.string.codes_add_are_you_sure),
        sheetState = sheetState,
        bottomSheetContent = {
            ConfirmDialog(
                subtitle = stringResource(R.string.codes_add_progress_will_be_lost),
                firstButton = ConfirmDialogButton(
                    label = stringResource(R.string.common_exit),
                    onClick = { onAction(AddCodeAction.BackClick) },
                ),
                secondButton = ConfirmDialogButton(
                    label = stringResource(R.string.common_cancel),
                    onClick = { coroutineScope.launch { sheetState.hide() } }
                )
            )
        },
        content = {
            AddCodeContent(
                state = state,
                onAction = onAction,
                onBackClick = {
                    if (state.isNotEmpty) {
                        showSheet()
                    } else {
                        onAction(AddCodeAction.BackClick)
                    }
                }
            )
        }
    )
}