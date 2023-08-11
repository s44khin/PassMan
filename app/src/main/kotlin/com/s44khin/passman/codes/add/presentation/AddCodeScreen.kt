package com.s44khin.passman.codes.add.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.data.isNotEmpty
import com.s44khin.passman.codes.add.presentation.widgets.AddCodeContent
import com.s44khin.passman.common.presentation.confirmDialog.ConfirmDialog
import com.s44khin.passman.common.presentation.confirmDialog.ConfirmDialogButton
import com.s44khin.passman.core.BaseScreen
import com.s44khin.uikit.util.BottomSheetWrapper

@Composable
fun AddCodeScreen() = BaseScreen<AddCodeState, AddCodeAction, AddCodeViewModel> {
    var bottomSheetIsOpen by remember { mutableStateOf(false) }

    BackHandler(enabled = state.isNotEmpty) {
        bottomSheetIsOpen = !bottomSheetIsOpen
    }

    BottomSheetWrapper(
        modifier = Modifier.imePadding(),
        bottomSheetIsOpen = bottomSheetIsOpen,
        onDismissRequest = { bottomSheetIsOpen = false },
        content = {
            ConfirmDialog(
                title = stringResource(R.string.codes_add_are_you_sure),
                subtitle = stringResource(R.string.codes_add_progress_will_be_lost),
                firstButton = ConfirmDialogButton(
                    label = stringResource(R.string.common_exit),
                    onClick = { onAction(AddCodeAction.BackClick) },
                ),
                secondButton = ConfirmDialogButton(
                    label = stringResource(R.string.common_cancel),
                    onClick = { bottomSheetIsOpen = false }
                )
            )
        },
    )

    AddCodeContent(
        state = state,
        onAction = onAction,
        onBackClick = {
            if (state.isNotEmpty) {
                bottomSheetIsOpen = true
            } else {
                onAction(AddCodeAction.BackClick)
            }
        }
    )
}