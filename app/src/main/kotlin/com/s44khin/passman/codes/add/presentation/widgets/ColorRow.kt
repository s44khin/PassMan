package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.passman.common.presentation.widgets.ColorCarousel
import com.s44khin.uikit.layouts.TitleBlock

@Composable
fun ColorBlock(
    modifier: Modifier = Modifier,
    state: AddCodeState,
    onAction: (AddCodeAction) -> Unit,
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.codes_color),
        spacerHeight = 16.dp,
    ) {
        ColorCarousel(
            selectedItem = state.color,
            onColorClick = { onAction(AddCodeAction.ChangeColor(it)) }
        )
    }
}
