package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppColumn
import com.s44khin.uikit.widgets.AppDivider
import com.s44khin.uikit.widgets.AppTextField

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
        AppColumn {
            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                borderColor = AppTheme.colors.background,
                value = state.account,
                label = stringResource(R.string.codes_account),
                onValueChange = { onAction(AddCodeAction.ChangeAccount(it)) },
            )

            AppDivider(startIndent = 12.dp)

            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(0.dp),
                borderColor = AppTheme.colors.background,
                value = state.description,
                label = stringResource(R.string.codes_description),
                onValueChange = { onAction(AddCodeAction.ChangeDescription(it)) },
            )
        }
    }
}