package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.widgets.AppTextField
import com.s44khin.uikit.widgets.Spacer

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
        AppTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = state.account,
            label = stringResource(R.string.codes_account),
            onValueChange = { onAction(AddCodeAction.ChangeAccount(it)) },
        )

        Spacer(height = 16.dp)

        AppTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = state.description,
            label = stringResource(R.string.codes_description),
            onValueChange = { onAction(AddCodeAction.ChangeDescription(it)) },
        )
    }
}