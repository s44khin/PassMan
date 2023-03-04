package com.s44khin.passman.codes.master.presentation.widgets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.s44khin.passman.codes.master.presentation.data.TotpItemVO
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.Spacer

@Immutable
private data class State(
    val code: String,
    val nextCode: String,
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ColumnScope.CodesListItem(item: TotpItemVO) {
    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
        Bullet(
            modifier = Modifier.align(Alignment.CenterVertically),
            color = item.color.color
        )

        Spacer(width = 16.dp)

        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = item.name,
                color = AppTheme.colors.textOnBackgroundVariant,
            )

            Spacer(height = 8.dp)

            AnimatedContent(targetState = State(item.code, item.nextCode)) {
                Row {
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = it.code,
                        color = AppTheme.colors.textOnBackground,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(width = 8.dp)

                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = it.nextCode,
                        color = AppTheme.colors.textOnBackgroundVariant,
                        fontSize = 16.sp,
                    )
                }
            }
        }
    }
}

@Composable
fun Bullet(
    modifier: Modifier = Modifier,
    color: Color
) {
    Spacer(
        modifier = modifier
            .size(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color)
    )
}
