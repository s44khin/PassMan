package com.s44khin.uikit.util

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.s44khin.uikit.theme.AppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetWrapper(
    modifier: Modifier = Modifier,
    bottomSheetIsOpen: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    val bottomSheetState = rememberModalBottomSheetState()
    var _bottomSheetIsOpen by remember { mutableStateOf(false) }

    LaunchedEffect(bottomSheetIsOpen) {
        if (bottomSheetIsOpen) {
            _bottomSheetIsOpen = true
            delay(250)
            bottomSheetState.show()
        } else {
            this.launch { bottomSheetState.hide() }.invokeOnCompletion { _bottomSheetIsOpen = false }
        }
    }

    if (_bottomSheetIsOpen) {
        ModalBottomSheet(
            modifier = modifier,
            sheetState = bottomSheetState,
            content = content,
            containerColor = AppTheme.colors.background,
            onDismissRequest = onDismissRequest
        )
    }
}
