package com.s44khin.uikit.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme

@Composable
fun ColumnScope.AppDivider(modifier: Modifier = Modifier, startIndent: Dp = 0.dp) = Divider(
    modifier = modifier,
    startIndent = startIndent,
    thickness = 0.5.dp,
    color = AppTheme.colors.divider
)

@Composable
fun RowScope.AppDivider(modifier: Modifier = Modifier, topIndent: Dp = 0.dp) = Box(
    modifier = modifier
        .padding(top = topIndent)
        .fillMaxHeight()
        .width(0.5.dp)
        .background(color = AppTheme.colors.divider)
)
