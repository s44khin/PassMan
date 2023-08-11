package com.s44khin.uikit.util

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBars
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.statusBarsHeight(additional: Dp = 0.dp) = composed {
    height(
        height = with(LocalDensity.current) {
            WindowInsets.statusBars.getTop(LocalDensity.current).toDp() + additional
        }
    )
}
