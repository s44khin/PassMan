package com.s44khin.passman.common.presentation.widgets

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.PrimaryColor
import com.s44khin.uikit.widgets.Spacer

@Composable
fun ColorCarousel(
    modifier: Modifier = Modifier,
    selectedItem: PrimaryColor,
    contentHorizontalPadding: Dp = 16.dp,
    onColorClick: (PrimaryColor) -> Unit,
) {
    val colors = remember { PrimaryColor.values() }

    Row(modifier = modifier.horizontalScroll(rememberScrollState())) {
        Spacer(width = contentHorizontalPadding)

        colors.forEachIndexed { index, primaryColor ->
            ColorCarouselItem(
                selected = primaryColor == selectedItem,
                color = primaryColor,
                onClick = { onColorClick(primaryColor) }
            )

            if (index != colors.lastIndex) {
                Spacer(width = 8.dp)
            }
        }

        Spacer(width = contentHorizontalPadding)
    }
}