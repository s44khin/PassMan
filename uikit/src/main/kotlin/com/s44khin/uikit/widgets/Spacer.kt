package com.s44khin.uikit.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.s44khin.uikit.theme.AppTheme

@Composable
@NonRestartableComposable
fun ColumnScope.Spacer(height: Dp, color: Color = AppTheme.colors.background) = Spacer(
    modifier = Modifier
        .height(height)
        .background(color = color)
)

@Composable
@NonRestartableComposable
fun RowScope.Spacer(width: Dp, color: Color = AppTheme.colors.background) = Spacer(
    modifier = Modifier
        .width(width)
        .background(color = color)
)
