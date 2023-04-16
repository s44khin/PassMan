package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.settings.master.presentation.SettingsAction
import com.s44khin.passman.settings.master.presentation.SettingsState
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.widgets.AppColumn
import com.s44khin.uikit.widgets.AppColumnItemType

@Composable
fun CodesBlock(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onAction: (SettingsAction) -> Unit,
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.settings_codes),
    ) {
        AppColumn(
            content = listOf(
                AppColumnItemType.RadioButton(
                    label = stringResource(R.string.settings_show_next_code),
                    isSelected = state.showNextCode,
                    onClick = { onAction(SettingsAction.ChangeShowNextCode) }
                ),
                AppColumnItemType.RadioButton(
                    label = stringResource(R.string.settings_show_color),
                    isSelected = state.showColor,
                    onClick = { onAction(SettingsAction.ChangeShowColor) },
                ),
                AppColumnItemType.RadioButton(
                    label = stringResource(R.string.settings_show_account),
                    isSelected = state.showAccount,
                    onClick = { onAction(SettingsAction.ChangeShowAccount) },
                ),
            )
        )
    }
}
