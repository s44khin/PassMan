package com.s44khin.passman.codes.list.presentation.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.s44khin.passman.codes.list.presentation.CodesListAction
import com.s44khin.passman.codes.list.presentation.CodesListState
import com.s44khin.passman.util.isScrolledToTheEnd
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.util.clickableWithoutRipple
import com.s44khin.uikit.widgets.AppFab
import com.s44khin.uikit.widgets.AppFabData

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BoxScope.CodesListAnimatedContent(
    state: CodesListState,
    scrollState: LazyListState,
    onAction: (CodesListAction) -> Unit,
) {
    AnimatedVisibility(
        modifier = Modifier
            .statusBarsPadding()
            .padding(16.dp)
            .align(Alignment.TopCenter),
        enter = scaleIn() + fadeIn(),
        exit = scaleOut() + fadeOut(),
        visible = state.inEdit,
    ) {
        EditPopup(
            onPinClick = { onAction(CodesListAction.PinClick) },
            onDeleteClick = { onAction(CodesListAction.DeleteClick) },
            onCloseClick = { onAction(CodesListAction.StopEdit) }
        )
    }

    AnimatedVisibility(
        modifier = Modifier.fillMaxSize(),
        enter = fadeIn(),
        exit = fadeOut(),
        visible = state.isAddEnabled,
    ) {
        Spacer(
            modifier = Modifier
                .background(color = AppTheme.colors.overlay)
                .fillMaxSize()
                .clickableWithoutRipple { onAction(CodesListAction.OnAddDisabled) }
        )
    }

    AppFab(
        isOpen = state.isAddEnabled,
        visible = (!scrollState.isScrolledToTheEnd()) && !state.inEdit,
        appFabDataList = listOf(
            AppFabData(
                icon = Icons.Outlined.QrCode,
                onClick = { onAction(CodesListAction.QrCodeClick) },
            ),
            AppFabData(
                icon = Icons.Outlined.Edit,
                onClick = { onAction(CodesListAction.ManuallyClick) },
            ),
        ),
        mainFabContent = {
            FloatingActionButton(
                containerColor = AppTheme.colors.primary,
                contentColor = AppTheme.colors.textOnPrimary,
                onClick = {
                    onAction(
                        if (state.isAddEnabled) {
                            CodesListAction.OnAddDisabled
                        } else {
                            CodesListAction.OnAddClick
                        }
                    )
                }
            ) {
                val animatedRotation by animateFloatAsState(
                    targetValue = if (state.isAddEnabled) 45f else 0f
                )

                Icon(
                    modifier = Modifier.rotate(animatedRotation),
                    imageVector = Icons.Rounded.Add,
                    contentDescription = Icons.Rounded.Add.name,
                )
            }
        }
    )
}