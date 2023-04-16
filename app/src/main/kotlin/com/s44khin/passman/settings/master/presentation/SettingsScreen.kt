package com.s44khin.passman.settings.master.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.BuildConfig
import com.s44khin.passman.R
import com.s44khin.passman.core.BaseScreen
import com.s44khin.passman.settings.master.presentation.widgets.AppBlock
import com.s44khin.passman.settings.master.presentation.widgets.CodesBlock
import com.s44khin.passman.settings.master.presentation.widgets.DebugBlock
import com.s44khin.uikit.widgets.BottomNavigationHeight
import com.s44khin.uikit.widgets.Spacer
import com.s44khin.uikit.widgets.TopNav
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen() = BaseScreen<SettingsState, SettingsAction, SettingsViewModel> {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavigationHeight)
            .navigationBarsPadding()
    ) {
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()
        val isDebug = remember { BuildConfig.DEBUG }

        TopNav(
            label = stringResource(R.string.settings_label),
            onLabelClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
        )

        Spacer(height = 8.dp)

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Spacer(height = 8.dp)

            AppBlock(
                state = state,
                onAction = onAction
            )

            Spacer(height = 16.dp)

            CodesBlock(
                state = state,
                onAction = onAction,
            )

            if (isDebug) {
                Spacer(height = 16.dp)

                DebugBlock(
                    onAction = onAction
                )
            }
        }
    }
}