package dev.s44khin.passman.home.list.presentation.widgets

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.s44khin.passman.home.list.presentation.HomeAction
import dev.s44khin.passman.home.list.presentation.HomeState
import dev.s44khin.uikit.widgets.Spacer
import dev.s44khin.uikit.widgets.bottomNavHeight

private enum class ContentType {
    Account
}

private val firstShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp, bottomStart = 4.dp, bottomEnd = 4.dp)
private val defaultShape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 4.dp, bottomEnd = 4.dp)
private val lastShape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 16.dp, bottomEnd = 16.dp)


@Composable
fun ColumnScope.HomeScrollableContent(
    state: HomeState,
    scrollState: LazyListState,
    onAction: (HomeAction) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxWidth()
            .weight(1f),
        state = scrollState,
        contentPadding = PaddingValues(top = 16.dp, bottom = bottomNavHeight + 16.dp)
    ) {
        itemsIndexed(
            items = state.list,
            key = { _, item -> item.uid.uuid },
            contentType = { _, _ -> ContentType.Account }
        ) { index, account ->
            HomeAccountItem(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                accountVO = account,
                shape = when (index) {
                    0 -> firstShape
                    state.list.lastIndex -> lastShape
                    else -> defaultShape
                },
                onLongClick = { onAction(HomeAction.ItemLongClick(account)) },
                onClick = { onAction(HomeAction.ItemClick(account)) }
            )

            if (index != state.list.lastIndex) {
                Spacer(height = 4.dp)
            }
        }
    }
}
