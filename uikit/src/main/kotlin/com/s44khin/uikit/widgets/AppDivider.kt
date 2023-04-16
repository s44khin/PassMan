package com.s44khin.uikit.widgets

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme

@Composable
fun AppDivider(modifier: Modifier = Modifier, startIndent: Dp = 0.dp) = Divider(
    modifier = modifier,
    startIndent = startIndent,
    thickness = 0.5.dp,
    color = AppTheme.colors.divider
)
