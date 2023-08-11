package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.widgets.AppColumn
import com.s44khin.uikit.widgets.AppColumnItemType

@Composable
fun OptionalBlock(
    modifier: Modifier = Modifier,
    state: AddCodeState,
    onAction: (AddCodeAction) -> Unit
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.codes_optional),
    ) {
        AppColumn(
            content = mutableListOf(
                AppColumnItemType.TextField(
                    value = state.account,
                    label = stringResource(R.string.codes_account),
                    onValueChange = { onAction(AddCodeAction.ChangeAccount(it)) },
                ),
                AppColumnItemType.TextField(
                    value = state.description,
                    label = stringResource(R.string.codes_description),
                    onValueChange = { onAction(AddCodeAction.ChangeDescription(it)) },
                ),
                AppColumnItemType.RadioButton(
                    label = stringResource(R.string.codes_is_pinned),
                    isSelected = state.isPinned,
                    onClick = { onAction(AddCodeAction.ChangePinned) }
                ),
            ).apply {
                if (state.showNextCodeAvailable) {
                    add(
                        AppColumnItemType.RadioButton(
                            label = stringResource(R.string.codes_add_new_show_next_code),
                            isSelected = state.showNextCode,
                            onClick = { onAction(AddCodeAction.ChangeShowNextCode) }
                        )
                    )
                }
            }
        )
    }
}