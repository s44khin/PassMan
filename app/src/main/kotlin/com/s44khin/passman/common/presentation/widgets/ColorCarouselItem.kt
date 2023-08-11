package com.s44khin.passman.common.presentation.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.PrimaryColor

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ColorCarouselItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    color: PrimaryColor,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(42.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(24.dp))
            .background(color = color.primary)
            .clickable { onClick() }
    ) {
        val animatedAlpha by animateFloatAsState(
            targetValue = if (selected) 0.2f else 0.0f
        )

        AnimatedVisibility(
            modifier = Modifier
                .background(color = Color.Black.copy(alpha = animatedAlpha))
                .fillMaxSize(),
            visible = selected,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            Icon(
                modifier = Modifier.padding(8.dp),
                imageVector = Icons.Rounded.Done,
                tint = Color.White,
                contentDescription = Icons.Rounded.Done.name
            )
        }
    }
}
