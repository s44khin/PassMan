package com.s44khin.passman.codes.list.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.s44khin.passman.codes.list.presentation.widgets.CodesListAnimatedContent
import com.s44khin.passman.codes.list.presentation.widgets.CodesListScrollableContent
import com.s44khin.passman.core.BaseScreen
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.BottomNavigationHeight

@Composable
fun CodesListScreen() = BaseScreen<CodesListState, CodesListAction, CodesListViewModel> {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavigationHeight)
            .navigationBarsPadding()
    ) {
        val scrollState = rememberScrollState()

        Column(modifier = Modifier.fillMaxSize()) {
            when (state.mode) {
                CodesListMode.CONTENT -> CodesListScrollableContent(
                    scrollState = scrollState,
                    list = state.codes,
                    showNextCode = state.showNextCode,
                    showColor = state.showColor,
                    inEdit = state.inEdit,
                    onAction = onAction,
                )

                CodesListMode.LOADING -> CircularProgressIndicator()

                CodesListMode.ERROR -> TODO()

                CodesListMode.EMPTY -> Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(color = AppTheme.colors.background)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "You haven't added anything yet"
                    )
                }
            }
        }

        CodesListAnimatedContent(
            state = state,
            scrollState = scrollState,
            onAction = onAction,
        )
    }
}


