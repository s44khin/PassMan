package com.s44khin.passman.codes.list.presentation.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.s44khin.passman.codes.list.presentation.CodesListAction
import com.s44khin.passman.codes.list.presentation.CodesListMode
import com.s44khin.passman.codes.list.presentation.CodesListState
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.BottomNavigationHeight
import com.s44khin.uikit.widgets.TransparentStatusBar

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CodesList(
    state: CodesListState,
    onAddClick: () -> Unit,
    onAction: (CodesListAction) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BottomNavigationHeight)
            .navigationBarsPadding()
    ) {
        val scrollState = rememberScrollState()

        Column(modifier = Modifier.fillMaxSize()) {
            val systemUiController = rememberSystemUiController()
            val isSystemInDarkTheme = isSystemInDarkTheme()

            DisposableEffect(systemUiController, state.inEdit) {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = false
                )

                onDispose {
                    systemUiController.setStatusBarColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkTheme
                    )
                }
            }

            when (state.mode) {
                CodesListMode.CONTENT -> {
                    if (state.codes.isNotEmpty()) {
                        CodesListScrollableContent(
                            scrollState = scrollState,
                            list = state.codes,
                            showNextCode = state.showNextCode,
                            showColor = state.showColor,
                            inEdit = state.inEdit,
                            onAction = onAction,
                        )
                    } else {
                        Box(
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

                CodesListMode.LOADING -> CircularProgressIndicator()
                CodesListMode.ERROR -> TODO()
            }
        }

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

        TransparentStatusBar()

        AnimatedVisibility(
            modifier = Modifier
                .padding(bottom = 24.dp, end = 16.dp)
                .align(Alignment.BottomEnd),
            visible = (scrollState.value != scrollState.maxValue || scrollState.maxValue == 0) && !state.inEdit,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            FloatingActionButton(
                backgroundColor = AppTheme.colors.primary,
                contentColor = AppTheme.colors.textOnPrimary,
                onClick = {
                    onAddClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = Icons.Rounded.Add.name,
                )
            }
        }
    }
}