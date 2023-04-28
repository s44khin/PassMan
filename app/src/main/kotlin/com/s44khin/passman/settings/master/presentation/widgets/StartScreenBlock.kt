package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.settings.master.presentation.SettingsAction
import com.s44khin.passman.settings.master.presentation.SettingsState
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppDivider
import com.s44khin.uikit.widgets.AppRadioButton
import com.s44khin.uikit.widgets.AppRow
import com.s44khin.uikit.widgets.Spacer

@Composable
fun StartScreenBlock(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onAction: (SettingsAction) -> Unit,
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.settings_start_screen)
    ) {
        AppRow(modifier = Modifier.height(IntrinsicSize.Min)) {
            StartScreenItem(
                icon = Icons.Outlined.Code,
                label = stringResource(R.string.codes_label),
                selected = state.startScreen.isCodes(),
                onClick = { onAction(SettingsAction.OnCodesScreenClick) }
            )

            AppDivider()

            StartScreenItem(
                icon = Icons.Outlined.Password,
                label = stringResource(R.string.passwords_label),
                selected = state.startScreen.isPasswords(),
                onClick = { onAction(SettingsAction.OnPasswordsScreenClick) }
            )
        }
    }
}

@Composable
private fun RowScope.StartScreenItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clickable { onClick() }
            .padding(top = 16.dp, bottom = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = icon.name,
            tint = AppTheme.colors.textOnBackgroundVariant,
        )

        Spacer(height = 4.dp)

        Text(
            text = label,
            color = AppTheme.colors.textOnBackground,
        )

        AppRadioButton(
            selected = selected,
            onClick = onClick
        )
    }
}