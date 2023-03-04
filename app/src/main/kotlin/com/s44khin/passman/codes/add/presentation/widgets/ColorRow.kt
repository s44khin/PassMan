package com.s44khin.passman.codes.add.presentation.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.s44khin.passman.R
import com.s44khin.passman.codes.add.presentation.AddCodeAction
import com.s44khin.passman.codes.add.presentation.AddCodeState
import com.s44khin.passman.codes.add.presentation.data.CodeColor
import com.s44khin.uikit.widgets.Spacer

@Composable
fun ColumnScope.ColorBlock(
    modifier: Modifier = Modifier,
    state: AddCodeState,
    onAction: (AddCodeAction) -> Unit,
) {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = stringResource(R.string.codes_color),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )

    Spacer(height = 8.dp)

    Row(modifier = modifier.horizontalScroll(rememberScrollState())) {
        Spacer(width = 16.dp)

        CodeColor.values().forEachIndexed { index, color ->
            ColorRowItem(
                selected = state.color == color,
                codeColor = color,
                onClick = { onAction(AddCodeAction.ChangeColor(color)) }
            )

            if (index != CodeColor.values().lastIndex) {
                Spacer(width = 8.dp)
            }
        }

        Spacer(width = 16.dp)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun ColorRowItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    codeColor: CodeColor,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(48.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(24.dp))
            .background(color = codeColor.color)
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
