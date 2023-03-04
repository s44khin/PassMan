package com.s44khin.passman.codes.master.presentation.widgets

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.s44khin.passman.codes.master.presentation.data.TotpItemVO
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.Spacer

@Composable
fun ColumnScope.CodesListScrollableContent(
    scrollState: ScrollState,
    list: List<TotpItemVO>
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(color = AppTheme.colors.background)
            .verticalScroll(scrollState)
    ) {
        Spacer(height = 16.dp)

        list.forEachIndexed { index, totpItem ->
            CodesListItem(item = totpItem)

            if (index != list.lastIndex) {
                Divider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    startIndent = 48.dp,
                    thickness = 0.5.dp
                )
            }
        }
    }
}