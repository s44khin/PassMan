package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.s44khin.passman.R
import com.s44khin.passman.settings.master.presentation.SettingsAction
import com.s44khin.passman.settings.master.presentation.SettingsState
import com.s44khin.uikit.layouts.TitleBlock

@Composable
fun ThemeBlock(
    modifier: Modifier = Modifier,
    viewState: SettingsState,
    onAction: (SettingsAction) -> Unit
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.settings_theme),
    ) {
        ThemeSelector(
            currentTheme = viewState.currentTheme,
            onChangeTheme = { onAction(SettingsAction.ChangeTheme(it)) }
        )
    }
}
