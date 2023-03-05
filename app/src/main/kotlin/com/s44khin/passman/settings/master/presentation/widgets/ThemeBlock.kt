package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.s44khin.passman.R
import com.s44khin.passman.settings.master.presentation.SettingsAction
import com.s44khin.passman.settings.master.presentation.SettingsState
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.Spacer

@Composable
fun ThemeBlock(
    modifier: Modifier = Modifier,
    viewState: SettingsState,
    onAction: (SettingsAction) -> Unit
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(color = AppTheme.colors.background)
            .then(modifier)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(R.string.settings_theme),
            color = AppTheme.colors.textOnBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(height = 16.dp)

        ThemeSelector(
            currentTheme = viewState.currentTheme,
            onChangeTheme = { onAction(SettingsAction.ChangeTheme(it)) }
        )
    }
}