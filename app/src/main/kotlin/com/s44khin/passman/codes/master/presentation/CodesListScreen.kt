package com.s44khin.passman.codes.master.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.master.presentation.widgets.CodesListScrollableContent
import com.s44khin.passman.core.Screen
import com.s44khin.uikit.layouts.RootColumn
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.Spacer
import com.s44khin.uikit.widgets.TopNav
import com.s44khin.uikit.widgets.TopNavIcon
import kotlinx.coroutines.launch

@Composable
fun CodesListScreen() = Screen<CodesListState, CodesListAction, CodesListViewModel> {
    RootColumn(modifier = Modifier.fillMaxSize()) {
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()

        TopNav(
            label = stringResource(R.string.codes_label),
            backgroundColor = if (state.inEdit) AppTheme.colors.primary else AppTheme.colors.background,
            contentColor = if (state.inEdit) AppTheme.colors.textOnPrimary else AppTheme.colors.textOnBackground,
            navIcon = TopNavIcon(
                icon = Icons.Rounded.Close,
                visible = state.inEdit,
                onClick = { onAction(CodesListAction.StopEdit) }
            ),
            onLabelClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
            endIcons = listOf(
                TopNavIcon(
                    icon = Icons.Rounded.Add,
                    visible = !state.inEdit,
                    onClick = { onAction(CodesListAction.AddClick) }
                ),
                TopNavIcon(
                    icon = Icons.Rounded.Delete,
                    visible = state.inEdit,
                    onClick = { onAction(CodesListAction.DeleteClick) }
                ),
            )
        )

        Spacer(height = 8.dp, color = AppTheme.colors.rootBackground)

        CodesListScrollableContent(
            scrollState = scrollState,
            list = state.codes,
            inEdit = state.inEdit,
            onAction = onAction,
        )

        Spacer(height = 8.dp, color = AppTheme.colors.rootBackground)
    }
}


