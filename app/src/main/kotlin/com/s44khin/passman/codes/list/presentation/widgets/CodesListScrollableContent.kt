package com.s44khin.passman.codes.list.presentation.widgets

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s44khin.passman.codes.list.presentation.CodesListAction
import com.s44khin.passman.codes.list.presentation.data.TotpItemVO
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.util.statusBarsHeight
import com.s44khin.uikit.widgets.AppDivider

private enum class CodesListContentType { STATUS_BAR_SPACER, CODE_ITEM }

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ColumnScope.CodesListScrollableContent(
    state: LazyListState,
    list: List<TotpItemVO>,
    showNextCode: Boolean,
    showColor: Boolean,
    inEdit: Boolean,
    showAccount: Boolean,
    onAction: (CodesListAction) -> Unit
) {
    val animatedSpacer by animateDpAsState(targetValue = if (inEdit) 80.dp else 0.dp)

    LazyColumn(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(color = AppTheme.colors.background),
        state = state,
    ) {
        item(contentType = CodesListContentType.STATUS_BAR_SPACER) {
            Spacer(modifier = Modifier.statusBarsHeight(animatedSpacer))
        }

        itemsIndexed(
            items = list,
            contentType = { _, _ -> CodesListContentType.CODE_ITEM },
            key = { _, item -> item.uid }
        ) { index, totpItem ->
            Column(modifier = Modifier.animateItemPlacement()) {
                CodesListItem(
                    item = totpItem,
                    inEdit = inEdit,
                    showNextCode = showNextCode && totpItem.showNextCode,
                    showColor = showColor,
                    showAccount = showAccount,
                    onAction = onAction
                )

                if (index != list.lastIndex) {
                    AppDivider(startIndent = 48.dp)
                }
            }
        }
    }
}
