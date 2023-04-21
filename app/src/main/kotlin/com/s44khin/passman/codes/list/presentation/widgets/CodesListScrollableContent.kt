package com.s44khin.passman.codes.list.presentation.widgets

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s44khin.passman.codes.list.presentation.CodesListAction
import com.s44khin.passman.codes.list.presentation.data.TotpItemVO
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.util.statusBarsHeight
import com.s44khin.uikit.widgets.AppDivider

@Composable
fun ColumnScope.CodesListScrollableContent(
    scrollState: ScrollState,
    list: List<TotpItemVO>,
    showNextCode: Boolean,
    showColor: Boolean,
    inEdit: Boolean,
    showAccount: Boolean,
    onAction: (CodesListAction) -> Unit
) {
    val animatedSpacer by animateDpAsState(targetValue = if (inEdit) 80.dp else 0.dp)

    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(color = AppTheme.colors.background)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.statusBarsHeight(animatedSpacer))

        list.forEachIndexed { index, totpItem ->
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
