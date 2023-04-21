package com.s44khin.passman.settings.master.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.common.presentation.confirmDialog.ConfirmDialog
import com.s44khin.passman.common.presentation.confirmDialog.ConfirmDialogButton
import com.s44khin.passman.core.BaseScreen
import com.s44khin.passman.settings.master.presentation.widgets.SettingsScreenContent
import com.s44khin.uikit.util.BottomSheetWrapper

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsScreen() = BaseScreen<SettingsState, SettingsAction, SettingsViewModel> {
    BackHandler(enabled = sheetState.currentValue != ModalBottomSheetValue.Hidden) {
        hideSheet()
    }

    BottomSheetWrapper(
        title = stringResource(R.string.settings_are_you_sure),
        sheetState = sheetState,
        bottomSheetContent = {
            ConfirmDialog(
                subtitle = stringResource(R.string.settings_not_safe),
                firstButton = ConfirmDialogButton(
                    label = stringResource(R.string.settings_confirm),
                    onClick = {
                        onAction(SettingsAction.ChangeShowNextCode)
                        hideSheet()
                    }
                ),
                secondButton = ConfirmDialogButton(
                    label = stringResource(R.string.common_cancel),
                    onClick = { hideSheet() }
                )
            )
        },
        content = {
            SettingsScreenContent(
                state = state,
                onAction = onAction,
                onShowNextCodeClick = {
                    if (!state.showNextCode) {
                        showSheet()
                    } else {
                        onAction(SettingsAction.ChangeShowNextCode)
                    }
                }
            )
        }
    )
}