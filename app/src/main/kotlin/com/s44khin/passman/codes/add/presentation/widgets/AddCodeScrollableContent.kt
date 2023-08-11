package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.uikit.widgets.Spacer

@Composable
fun AddCodeScrollableContent(
    modifier: Modifier = Modifier,
    state: AddCodeState,
    scrollState: ScrollState,
    onAction: (AddCodeAction) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        Spacer(height = 24.dp)

        RequiredBlock(
            state = state,
            onAction = onAction,
        )

        Spacer(height = 24.dp)

        ColorBlock(
            state = state,
            onAction = onAction
        )

        Spacer(height = 24.dp)

        OptionalBlock(
            state = state,
            onAction = onAction,
        )

        Spacer(height = 24.dp)
    }
}