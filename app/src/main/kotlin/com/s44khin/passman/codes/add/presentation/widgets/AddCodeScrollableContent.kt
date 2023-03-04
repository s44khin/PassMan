package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppTextField
import com.s44khin.uikit.widgets.Spacer

@Composable
fun ColumnScope.AddCodeScrollableContent(
    modifier: Modifier = Modifier,
    state: AddCodeState,
    scrollState: ScrollState,
    onAction: (AddCodeAction) -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .background(AppTheme.colors.background)
    ) {
        Spacer(height = 16.dp)

        AppTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = state.name,
            label = stringResource(R.string.codes_name),
            onValueChange = { onAction(AddCodeAction.ChangeName(it)) },
        )

        Spacer(height = 16.dp)

        AppTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = state.secretCode,
            label = stringResource(R.string.codes_secret_code),
            onValueChange = { onAction(AddCodeAction.ChangeSecretCode(it)) },
        )

        Spacer(height = 24.dp)

        ColorBlock(state = state, onAction = onAction)
    }
}