package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.passman.codes.add.presentation.data.buttonIsEnabled
import com.s44khin.uikit.widgets.BottomButton
import com.s44khin.uikit.widgets.TopNav
import com.s44khin.uikit.widgets.TopNavIcon
import kotlinx.coroutines.launch

@Composable
fun AddCodeContent(
    state: AddCodeState,
    onAction: (AddCodeAction) -> Unit,
    onBackClick: () -> Unit,
) {
    Column(modifier = Modifier.imePadding()) {
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()

        TopNav(
            label = stringResource(R.string.codes_add_new_code_label),
            onLabelClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
            navIcon = TopNavIcon(
                icon = Icons.Rounded.ArrowBack,
                onClick = {
                    onBackClick()
                }
            )
        )

        AddCodeScrollableContent(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(24.dp)),
            state = state,
            scrollState = scrollState,
            onAction = onAction,
        )

        BottomButton(
            label = stringResource(R.string.codes_add_confirm),
            enabled = state.buttonIsEnabled,
            onClick = { onAction(AddCodeAction.SaveClick) }
        )
    }
}