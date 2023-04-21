package com.s44khin.passman.codes.list.presentation.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@NonRestartableComposable
fun Bullet(
    modifier: Modifier = Modifier,
    isPinned: Boolean,
    color: Color
) {
    Spacer(
        modifier = modifier
            .size(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(
                shape = RoundedCornerShape(8.dp),
                color = color,
                width = if (isPinned) 4.dp else 8.dp
            )
    )
}