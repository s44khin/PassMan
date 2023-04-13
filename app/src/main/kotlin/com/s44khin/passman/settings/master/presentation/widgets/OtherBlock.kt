package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.settings.master.presentation.SettingsAction
import com.s44khin.passman.settings.master.presentation.SettingsState
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppRadioButton

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
            Row(
                modifier = Modifier
                    .clickable { onAction(SettingsAction.ChangeShowNextCode) }
                    .padding(start = 16.dp, top = 6.dp, end = 6.dp, bottom = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(R.string.settings_show_next_code),
                    color = AppTheme.colors.textOnBackground
                )

                AppRadioButton(
                    selected = state.showNextCode,
                    onClick = { onAction(SettingsAction.ChangeShowNextCode) }
                )
            }

            Divider(startIndent = 16.dp, thickness = 0.5.dp)

            Row(
                modifier = Modifier
                    .clickable { onAction(SettingsAction.ChangeShowColor) }
                    .padding(start = 16.dp, top = 6.dp, end = 6.dp, bottom = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(R.string.settings_show_color),
                    color = AppTheme.colors.textOnBackground
                )

                AppRadioButton(
                    selected = state.showColor,
                    onClick = { onAction(SettingsAction.ChangeShowColor) }
                )
            }
        }
    }
}
