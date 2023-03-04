package com.s44khin.passman.codes.add.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.widgets.AddCodeScrollableContent
import com.s44khin.passman.core.Screen
import com.s44khin.uikit.layouts.RootBox
import com.s44khin.uikit.layouts.RootColumn
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.Spacer
import com.s44khin.uikit.widgets.TopNav
import com.s44khin.uikit.widgets.TopNavIcon
import kotlinx.coroutines.launch

@Composable
fun AddCodeScreen() = Screen<AddCodeState, AddCodeAction, AddCodeViewModel> {
    RootBox {
        RootColumn {
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
                    onClick = { onAction(AddCodeAction.BackClick) }
                )
            )

            Spacer(height = 8.dp, color = AppTheme.colors.rootBackground)

            AddCodeScrollableContent(
                modifier = Modifier.weight(1f),
                state = state,
                scrollState = scrollState,
                onAction = onAction,
            )

            Spacer(height = 8.dp, color = AppTheme.colors.rootBackground)
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 24.dp),
            backgroundColor = AppTheme.colors.primary,
            contentColor = AppTheme.colors.textOnPrimary,
            onClick = { onAction(AddCodeAction.SaveClick) }
        ) {
            Icon(imageVector = Icons.Rounded.Done, contentDescription = Icons.Rounded.Done.name)
        }
    }
}