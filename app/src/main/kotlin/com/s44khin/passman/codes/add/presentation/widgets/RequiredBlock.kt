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
fun RequiredBlock(
    modifier: Modifier = Modifier,
    state: AddCodeState,
    onAction: (AddCodeAction) -> Unit
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.codes_required),
    ) {
        AppColumn(
            content = listOf(
                AppColumnItemType.TextField(
                    value = state.name,
                    label = stringResource(R.string.codes_name),
                    onValueChange = { onAction(AddCodeAction.ChangeName(it)) }
                ),
                AppColumnItemType.TextField(
                    value = state.secretCode,
                    label = stringResource(R.string.codes_secret_code),
                    onValueChange = { onAction(AddCodeAction.ChangeSecretCode(it)) }
                ),
            )
        )
    }
}
