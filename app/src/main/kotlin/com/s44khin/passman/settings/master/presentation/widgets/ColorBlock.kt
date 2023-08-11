package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.common.presentation.widgets.ColorCarousel
import com.s44khin.passman.settings.master.presentation.SettingsAction
import com.s44khin.passman.settings.master.presentation.SettingsState
import com.s44khin.uikit.layouts.TitleBlock

@Composable
fun ColorBlock(
    modifier: Modifier = Modifier,
    state: SettingsState,
    onAction: (SettingsAction) -> Unit,
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.codes_color),
        spacerHeight = 16.dp,
    ) {
        ColorCarousel(
            selectedItem = state.color,
            onColorClick = { onAction(SettingsAction.ChangeColor(it)) }
        )
    }
}