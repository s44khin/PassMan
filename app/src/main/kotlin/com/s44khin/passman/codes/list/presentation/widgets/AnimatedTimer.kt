package com.s44khin.passman.codes.list.presentation.widgets

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.s44khin.uikit.theme.AppTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedTimer(
    modifier: Modifier = Modifier,
    value: Int
) {
    AnimatedContent(
        modifier = modifier,
        targetState = value,
        transitionSpec = {
            if (targetState > initialState) {
                slideInVertically { it } + fadeIn() with slideOutVertically { -it } + fadeOut()
            } else {
                slideInVertically { it } + fadeIn() with slideOutVertically { -it } + fadeOut()
            }.using(
                SizeTransform(clip = false)
            )
        }
    ) { targetCount ->
        Text(
            text = "$targetCount",
            fontSize = 12.sp,
            color = AppTheme.colors.textOnBackgroundVariant
        )
    }
}
