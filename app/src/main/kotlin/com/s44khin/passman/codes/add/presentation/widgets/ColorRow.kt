package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.passman.codes.add.presentation.data.CodeColor
import com.s44khin.uikit.layouts.TitleBlock
import com.s44khin.uikit.widgets.Spacer

@Composable
fun ColorBlock(
    modifier: Modifier = Modifier,
    state: AddCodeState,
    onAction: (AddCodeAction) -> Unit,
) {
    TitleBlock(
        modifier = modifier,
        title = stringResource(R.string.codes_color),
    ) {
        Row(modifier = modifier.horizontalScroll(rememberScrollState())) {
            Spacer(width = 16.dp)

            CodeColor.values().forEachIndexed { index, color ->
                ColorRowItem(
                    selected = state.color == color,
                    codeColor = color,
                    onClick = { onAction(AddCodeAction.ChangeColor(color)) }
                )

                if (index != CodeColor.values().lastIndex) {
                    Spacer(width = 8.dp)
                }
            }
        }
    }
}
