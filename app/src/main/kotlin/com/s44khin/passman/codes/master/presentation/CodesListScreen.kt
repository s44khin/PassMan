package com.s44khin.passman.codes.master.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
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
            onLabelClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
            endIcon = TopNavIcon(
                icon = Icons.Rounded.Add,
                onClick = { onAction(CodesListAction.AddClick) }
            )
        )

        Spacer(height = 8.dp, color = AppTheme.colors.rootBackground)

        CodesListScrollableContent(
            scrollState = scrollState,
            list = state.codes
        )

        Spacer(height = 8.dp, color = AppTheme.colors.rootBackground)
    }
}


