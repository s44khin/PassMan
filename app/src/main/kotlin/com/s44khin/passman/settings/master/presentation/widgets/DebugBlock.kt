package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.settings.master.presentation.SettingsAction
import com.s44khin.uikit.layouts.TitleBlock

@Composable
fun DebugBlock(
    modifier: Modifier = Modifier,
    onAction: (SettingsAction) -> Unit,
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.settings_debug)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .border(
                    width = 0.5.dp,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                    shape = RoundedCornerShape(24.dp)
                )
                .clip(RoundedCornerShape(24.dp))
        ) {
            DebugButton(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.settings_debug_add_data),
                onClick = { onAction(SettingsAction.AddDebugData) }
            )

            Divider(startIndent = 16.dp, thickness = 0.5.dp)

            DebugButton(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.settings_debug_delete_all),
                onClick = { onAction(SettingsAction.DeleteAll) }
            )
        }
    }
}
