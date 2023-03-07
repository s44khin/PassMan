package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.uikit.widgets.RootSpacer

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
        RequiredBlock(
            modifier = Modifier.padding(vertical = 16.dp),
            state = state,
            onAction = onAction,
        )

        RootSpacer(height = 8.dp)

        ColorBlock(
            modifier = Modifier.padding(vertical = 16.dp),
            state = state,
            onAction = onAction
        )

        RootSpacer(height = 8.dp)

        OptionalBlock(
            modifier = Modifier.padding(vertical = 16.dp),
            state = state,
            onAction = onAction,
        )
    }
}