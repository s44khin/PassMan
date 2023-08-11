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
fun AppBlock(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onAction: (SettingsAction) -> Unit,
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.settings_app),
    ) {
        AppColumn(
            content = listOf(
                AppColumnItemType.Switch(
                    label = stringResource(R.string.settings_always_show_label),
                    isSelected = state.alwaysShowLabel,
                    onClick = { onAction(SettingsAction.ChangeShowLabel) }
                )
            )
        )
    }
}
