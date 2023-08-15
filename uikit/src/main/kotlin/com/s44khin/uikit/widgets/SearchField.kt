package com.s44khin.uikit.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.R

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    text: String,
    onChangeFocus: (Boolean) -> Unit,
    onInput: (String) -> Unit,
    onCloseClick: () -> Unit,
) {
    var isFocused by remember { mutableStateOf(false) }

    val animatedElevation by animateDpAsState(
        targetValue = if (isFocused) 0.dp else 3.dp,
        label = "animatedElevation"
    )

    val animatedColor by animateColorAsState(
        targetValue = if (isFocused) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.secondaryContainer,
        label = "animatedContentColor"
    )

    val animatedContentColor by animateColorAsState(
        targetValue = if (isFocused) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSecondaryContainer,
        label = "animatedContentColor"
    )

    val animatedPadding by animateDpAsState(
        targetValue = if (isFocused) 8.dp else 16.dp,
        label = "animatedPadding"
    )

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(horizontal = animatedPadding)
            .onFocusChanged {
                isFocused = it.isFocused
                onChangeFocus(isFocused)
            },
        value = text,
        onValueChange = onInput,
        maxLines = 1,
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyLarge.copy(color = animatedContentColor),
        cursorBrush = Brush.verticalGradient(
            0.00f to MaterialTheme.colorScheme.onSurface,
            1.00f to MaterialTheme.colorScheme.onSurface,
        ),
    ) { innerTextField ->
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = animatedColor,
            tonalElevation = animatedElevation,
            shape = CircleShape,
            shadowElevation = 0.dp
        ) {
            Row {
                Icon(
                    modifier = Modifier
                        .padding(14.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = animatedContentColor,
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 14.dp)
                ) {
                    innerTextField()

                    if (!isFocused || text.isEmpty()) {
                        Text(
                            modifier = Modifier.align(Alignment.TopStart),
                            text = stringResource(R.string.search),
                            style = MaterialTheme.typography.bodyLarge,
                            color = animatedContentColor,
                        )
                    }
                }

                AnimatedVisibility(
                    modifier = Modifier
                        .padding(14.dp)
                        .align(Alignment.CenterVertically),
                    visible = text.isNotBlank(),
                    enter = scaleIn() + fadeIn(),
                    exit = scaleOut() + fadeOut()
                ) {
                    Icon(
                        modifier = Modifier.clickable { onCloseClick() },
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = animatedContentColor,
                    )
                }
            }
        }
    }
}