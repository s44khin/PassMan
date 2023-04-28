package com.s44khin.passman.settings.master.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.common.presentation.confirmDialog.ConfirmDialog
import com.s44khin.passman.common.presentation.confirmDialog.ConfirmDialogButton
import com.s44khin.passman.core.BaseScreen
import com.s44khin.passman.settings.master.presentation.widgets.SettingsScreenContent
import com.s44khin.uikit.util.BottomSheetWrapper

@Composable
fun SettingsScreen() = BaseScreen<SettingsState, SettingsAction, SettingsViewModel> {
    var bottomSheetIsOpen by remember { mutableStateOf(false) }

    BackHandler(enabled = bottomSheetIsOpen) {
        bottomSheetIsOpen = false
    }

    SettingsScreenContent(
        state = state,
        onAction = onAction,
        onShowNextCodeClick = {
            if (state.showNextCode) {
                onAction(SettingsAction.ChangeShowNextCode)
            } else {
                bottomSheetIsOpen = true
            }
        }
    )

    BottomSheetWrapper(
        bottomSheetIsOpen = bottomSheetIsOpen,
        onDismissRequest = { bottomSheetIsOpen = false },
        content = {
            ConfirmDialog(
                title = stringResource(R.string.settings_are_you_sure),
                subtitle = stringResource(R.string.settings_not_safe),
                firstButton = ConfirmDialogButton(
                    label = stringResource(R.string.settings_confirm),
                    onClick = {
                        onAction(SettingsAction.ChangeShowNextCode)
                        bottomSheetIsOpen = false
                    }
                ),
                secondButton = ConfirmDialogButton(
                    label = stringResource(R.string.common_cancel),
                    onClick = { bottomSheetIsOpen = false }
                )
            )
        }
    )
}