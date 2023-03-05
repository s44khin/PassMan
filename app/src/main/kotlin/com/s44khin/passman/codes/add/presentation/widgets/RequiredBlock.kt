package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.widgets.AppTextField
import com.s44khin.uikit.widgets.Spacer

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
        AppTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = state.name,
            label = stringResource(R.string.codes_name),
            capitalization = KeyboardCapitalization.Words,
            onValueChange = { onAction(AddCodeAction.ChangeName(it)) },
        )

        Spacer(height = 16.dp)

        AppTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = state.secretCode,
            label = stringResource(R.string.codes_secret_code),
            capitalization = KeyboardCapitalization.Words,
            onValueChange = { onAction(AddCodeAction.ChangeSecretCode(it)) },
        )

        Spacer(height = 16.dp)

        AppTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = state.updateTimer,
            label = stringResource(R.string.codes_update_timer),
            keyboardType = KeyboardType.Number,
            onValueChange = { onAction(AddCodeAction.ChangTimer(it)) },
        )
    }
}
