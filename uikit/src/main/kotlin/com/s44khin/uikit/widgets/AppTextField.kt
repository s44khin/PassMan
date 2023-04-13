package com.s44khin.uikit.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.s44khin.uikit.theme.AppTheme

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    enabled: Boolean = true,
    maxLines: Int = 1,
    shape: Shape = RoundedCornerShape(24.dp),
    borderColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
    hintOverflow: TextOverflow = TextOverflow.Clip,
    backgroundColor: Color = AppTheme.colors.background,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit,
) {
    var isFocused by rememberSaveable { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .background(color = backgroundColor, shape = shape)
            .clip(shape)
            .border(
                width = 0.5.dp,
                color = borderColor,
                shape = shape
            )
            .clipToBounds()
            .onFocusChanged { focusState -> isFocused = focusState.isFocused },
        value = value,
        enabled = enabled,
        maxLines = maxLines,
        singleLine = maxLines <= 1,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        onValueChange = { newValue -> onValueChange(newValue) },
        cursorBrush = Brush.verticalGradient(
            0.00f to AppTheme.colors.primary,
            1.00f to AppTheme.colors.primary,
        ),
        textStyle = TextStyle.Default.copy(fontSize = 18.sp)
    ) { innerTextField ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clipToBounds()
                .animateContentSize(),
            contentAlignment = Alignment.TopStart,
        ) {
            val animatedSize by animateFloatAsState(targetValue = if (value.isNotEmpty() || isFocused) 12f else 16f)
            val animatedPadding by animateDpAsState(
                targetValue = if (value.isNotEmpty() || isFocused) 6.dp else 18.dp,
            )

            Text(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 16.dp, top = animatedPadding),
                text = label,
                color = AppTheme.colors.textOnBackground.copy(alpha = 0.5f),
                fontSize = animatedSize.sp,
                maxLines = 1,
                overflow = hintOverflow,
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp, top = 24.dp, bottom = 9.dp)
                    .fillMaxWidth()
                    .clipToBounds(),
            ) {
                innerTextField()
            }
        }
    }
}
