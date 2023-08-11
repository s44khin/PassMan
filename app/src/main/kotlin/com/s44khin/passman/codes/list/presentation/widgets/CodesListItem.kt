package com.s44khin.passman.codes.list.presentation.widgets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.s44khin.passman.codes.list.presentation.CodesListAction
import com.s44khin.passman.codes.list.presentation.data.TotpItemVO
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppRadioButton
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
    showNextCode: Boolean,
    showColor: Boolean,
    showAccount: Boolean,
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
                    } else {
                        onAction(CodesListAction.CopyToClipboard(item.code))
                    }
                }
            )
            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (showColor) {
            Bullet(color = item.color.primary, isPinned = item.pinned)
        }

        Spacer(width = 16.dp)

        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.name,
                    color = AppTheme.colors.textOnBackgroundVariant,
                )

                if (item.account != null && showAccount) {
                    Spacer(width = 2.dp)

                    Text(
                        text = "·",
                        color = AppTheme.colors.textOnBackgroundVariant,
                    )

                    Spacer(width = 2.dp)

                    Text(
                        text = item.account,
                        color = AppTheme.colors.textOnBackgroundVariant,
                        fontSize = 12.sp,
                    )
                }
            }
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

                    if (showNextCode) {
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
        }

        AnimatedVisibility(
            visible = inEdit,
            enter = fadeIn() + slideInHorizontally { it },
            exit = fadeOut() + slideOutHorizontally { it },
        ) {
            AppRadioButton(
                selected = item.checked,
                onClick = { onAction(CodesListAction.CheckedClick(item.uid)) }
            )
        }
    }
}
