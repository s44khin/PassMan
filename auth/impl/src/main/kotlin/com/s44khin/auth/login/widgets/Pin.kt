package com.s44khin.auth.login.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.s44khin.auth.login.LoginAction
import com.s44khin.auth.login.LoginViewState
import com.s44khin.common.api.core.SideEffect

@Composable
internal fun Pin(
    viewState: LoginViewState,
    modifier: Modifier = Modifier,
    onAction: (LoginAction) -> Unit,
) {
    SideEffect(
        effect = viewState.sideEffects.firstOrNull(),
        timeMillis = 250
    ) { effect ->
        if (effect != null) {
            onAction(LoginAction.ErrorEnd(effect))
        }
    }

    val transition = rememberInfiniteTransition(
        label = "transition",
    )

    val animated by transition.animateFloat(
        initialValue = -3f,
        targetValue = 3f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(durationMillis = 50),
            repeatMode = RepeatMode.Reverse
        ),
        label = "animated"
    )

    Row(
        modifier = modifier
            .animateContentSize()
            .let { if (viewState.isError) it.offset(x = animated.dp) else it }
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(
            space = 4.dp
        )
    ) {
        AnimatedVisibility(
            modifier = modifier.animateContentSize(),
            visible = viewState.pin.length >= 1,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            PinItem(inError = viewState.isError)
        }

        AnimatedVisibility(
            modifier = modifier.animateContentSize(),
            visible = viewState.pin.length >= 2,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            PinItem(inError = viewState.isError)
        }

        AnimatedVisibility(
            modifier = modifier.animateContentSize(),
            visible = viewState.pin.length >= 3,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            PinItem(inError = viewState.isError)
        }

        AnimatedVisibility(
            modifier = modifier.animateContentSize(),
            visible = viewState.pin.length >= 4,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            PinItem(inError = viewState.isError)
        }
    }
}

@Composable
private fun PinItem(inError: Boolean) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(16.dp)
            .background(
                color = if (inError) {
                    MaterialTheme.colorScheme.error
                } else {
                    MaterialTheme.colorScheme.onPrimaryContainer
                }
            )
    )
}