package com.s44khin.passman.codes.master.presentation.widgets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.s44khin.passman.codes.master.presentation.CodesListAction
import com.s44khin.passman.codes.master.presentation.data.TotpItemVO
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppCheckBox
import com.s44khin.uikit.widgets.Spacer

@Immutable
private data class State(
    val code: String,
    val nextCode: String,
)

@OptIn(ExperimentalAnimationApi::class, ExperimentalFoundationApi::class)
@Composable
fun CodesListItem(
    item: TotpItemVO,
    inEdit: Boolean,
    onAction: (CodesListAction) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onLongClick = { onAction(CodesListAction.StartEdit(item.uid)) },
                onClick = {
                    if (inEdit) {
                        onAction(CodesListAction.CheckedClick(item.uid))
                    }
                }
            )
            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Bullet(color = item.color.color)

        Spacer(width = 16.dp)

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.name,
                color = AppTheme.colors.textOnBackgroundVariant,
            )

            Spacer(height = 4.dp)

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

                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(14.dp),
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = Icons.Rounded.ArrowBack.name,
                        tint = AppTheme.colors.textOnBackgroundVariant,
                    )

                    Spacer(width = 2.dp)

                    AnimatedTimer(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        value = item.timer
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

        AnimatedVisibility(
            visible = inEdit,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut(),
        ) {
            AppCheckBox(
                checked = item.checked,
                onCheckedChange = { onAction(CodesListAction.CheckedClick(item.uid)) }
            )
        }
    }
}
