package com.s44khin.passman.codes.list.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Block
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.s44khin.passman.R
import com.s44khin.passman.codes.list.presentation.widgets.CodesListAnimatedContent
import com.s44khin.passman.codes.list.presentation.widgets.CodesListScrollableContent
import com.s44khin.passman.core.BaseScreen
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppButtonSmall
import com.s44khin.uikit.widgets.BottomNavigationHeight
import com.s44khin.uikit.widgets.Spacer

@Composable
fun CodesListScreen() = BaseScreen<CodesListState, CodesListAction, CodesListViewModel> {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavigationHeight)
            .navigationBarsPadding()
    ) {
        val scrollState = rememberLazyListState()

        Column(modifier = Modifier.fillMaxSize()) {
            when (state.mode) {
                CodesListMode.CONTENT -> CodesListScrollableContent(
                    state = scrollState,
                    list = state.codes,
                    showNextCode = state.showNextCode,
                    showColor = state.showColor,
                    inEdit = state.inEdit,
                    showAccount = state.showAccount,
                    onAction = onAction,
                )

                CodesListMode.LOADING -> CircularProgressIndicator()

                CodesListMode.ERROR -> TODO()

                CodesListMode.EMPTY -> Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = AppTheme.colors.background)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        modifier = Modifier.size(100.dp),
                        imageVector = Icons.Outlined.Block,
                        contentDescription = Icons.Outlined.Block.name,
                        tint = AppTheme.colors.textOnBackgroundVariant,
                    )

                    Spacer(height = 32.dp)

                    Text(
                        text = stringResource(R.string.codes_list_empty),
                        fontSize = 18.sp,
                        color = AppTheme.colors.textOnBackgroundVariant,
                        textAlign = TextAlign.Center,
                    )

                    Spacer(height = 32.dp)

                    AppButtonSmall(
                        label = stringResource(R.string.codes_add_new_code_label),
                        onClick = { onAction(CodesListAction.OnAddClick) }
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


