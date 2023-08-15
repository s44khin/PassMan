package com.s44khin.uikit.widgets

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarWithSearch(
    text: String,
    scrollState: LazyListState,
    onInput: (String) -> Unit,
    onCloseClick: () -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    var isFocused by remember { mutableStateOf(false) }

    val isScrolledToTop by remember {
        derivedStateOf { scrollState.firstVisibleItemIndex == 0 && scrollState.firstVisibleItemScrollOffset == 0 }
    }

    val isScrollInProgress = scrollState.isScrollInProgress

    if (isScrollInProgress) {
        focusManager.clearFocus()
    }

    val animatedElevation by animateDpAsState(
        targetValue = if (isScrolledToTop && !isFocused) 0.dp else 3.dp,
        label = "animatedElevation"
    )

    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = animatedElevation,
        color = MaterialTheme.colorScheme.surface
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            SearchField(
                modifier = Modifier
                    .align(Alignment.Center)
                    .focusRequester(focusRequester),
                text = text,
                onInput = onInput,
                onCloseClick = {
                    onCloseClick()
                    focusManager.clearFocus()
                },
                onChangeFocus = { isFocused = it }
            )
        }
    }
}