package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.settings.master.presentation.SettingsAction
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.widgets.AppColumn
import com.s44khin.uikit.widgets.AppColumnItemType

@Composable
fun DebugBlock(
    modifier: Modifier = Modifier,
    onAction: (SettingsAction) -> Unit,
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.settings_debug)
    ) {
        AppColumn(
            content = listOf(
                AppColumnItemType.Chevron(
                    label = stringResource(R.string.settings_debug_add_data),
                    onClick = { onAction(SettingsAction.AddDebugData) },
                ),
                AppColumnItemType.Chevron(
                    label = stringResource(R.string.settings_debug_delete_all),
                    onClick = { onAction(SettingsAction.DeleteAll) }
                )
            )
        )
    }
}
