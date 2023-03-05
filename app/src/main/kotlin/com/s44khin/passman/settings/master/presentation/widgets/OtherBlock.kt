package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.settings.master.presentation.SettingsAction
import com.s44khin.passman.settings.master.presentation.SettingsState
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppButton
import com.s44khin.uikit.widgets.AppCheckBox
import com.s44khin.uikit.widgets.Spacer

@Composable
fun OtherBlock(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onAction: (SettingsAction) -> Unit,
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.settings_other),
    ) {
        Row(
            modifier = Modifier.clickable { onAction(SettingsAction.ChangeShowNextCode) },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                text = stringResource(R.string.settings_show_next_code),
                color = AppTheme.colors.textOnBackground
            )

            AppCheckBox(
                checked = state.showNextCode,
                onCheckedChange = { onAction(SettingsAction.ChangeShowNextCode) }
            )
        }

        Spacer(height = 8.dp)

        AppButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = stringResource(R.string.settings_restart),
            enabled = state.buttonEnabled,
            onClick = { onAction(SettingsAction.Restart) }
        )
    }
}
