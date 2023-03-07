package com.s44khin.passman.codes.master.presentation.widgets

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.s44khin.passman.R
import com.s44khin.passman.codes.master.presentation.CodesListAction
import com.s44khin.passman.codes.master.presentation.CodesListState
import com.s44khin.uikit.layouts.RootColumn
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.BottomNavigationHeight
import com.s44khin.uikit.widgets.RootSpacer
import com.s44khin.uikit.widgets.TopNav
import com.s44khin.uikit.widgets.TopNavIcon
import kotlinx.coroutines.launch

@Composable
fun CodesList(
    state: CodesListState,
    onAddClick: () -> Unit,
    onAction: (CodesListAction) -> Unit,
) {
    RootColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavigationHeight)
            .navigationBarsPadding()
    ) {
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()
        val systemUiController = rememberSystemUiController()
        val isSystemInDarkTheme = isSystemInDarkTheme()

        DisposableEffect(systemUiController, state.inEdit) {
            systemUiController.setStatusBarColor(
                color = Color.Transparent,
                darkIcons = !state.inEdit && !isSystemInDarkTheme
            )

            onDispose {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = !isSystemInDarkTheme
                )
            }
        }

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
                    onClick = { onAddClick() }
                ),
                TopNavIcon(
                    icon = Icons.Rounded.Delete,
                    visible = state.inEdit,
                    onClick = { onAction(CodesListAction.DeleteClick) }
                ),
            )
        )

        RootSpacer(height = 8.dp)

        CodesListScrollableContent(
            scrollState = scrollState,
            list = state.codes,
            showNextCode = state.showNextCode,
            inEdit = state.inEdit,
            onAction = onAction,
        )

        RootSpacer(height = 8.dp)
    }
}