package com.s44khin.auth.login.widgets

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.auth.api.navigation.util.AuthStrings
import com.s44khin.auth.login.LoginAction
import com.s44khin.uikit.util.Spacer

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun NumPad(
    onAction: (LoginAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.extraLarge,
            )
            .navigationBarsPadding()
            .padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FlowRow(
            maxItemsInEachRow = 3,
            horizontalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterHorizontally,
            ),
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            (1..9).forEach {
                NunPadButton(
                    text = "$it",
                    onClick = { onAction(LoginAction.OnClick(it.digitToChar())) }
                )
            }
            NunPadDeleteButton(onClick = { onAction(LoginAction.Delete) })
            NunPadButton(text = "0", onClick = { onAction(LoginAction.OnClick('0')) })
            NunPadFingerprintButton(onClick = {})
        }

        Spacer(height = 48.dp)

        NunPadConfirmButton(onClick = {})
    }
}

@Composable
private fun NunPadButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    val isClicked by interactionSource.collectIsPressedAsState()

    val animatedShape by animateIntAsState(
        targetValue = if (isClicked) 25 else 50,
        label = "animatedShape"
    )

    Box(
        modifier = modifier
            .size(80.dp)
            .clip(shape = RoundedCornerShape(animatedShape))
            .background(color = MaterialTheme.colorScheme.primary)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
private fun NunPadDeleteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    val isClicked by interactionSource.collectIsPressedAsState()

    val animatedShape by animateIntAsState(
        targetValue = if (isClicked) 25 else 50,
        label = "animatedShape"
    )

    Box(
        modifier = modifier
            .size(80.dp)
            .clip(shape = RoundedCornerShape(animatedShape))
            .background(color = MaterialTheme.colorScheme.secondary)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Default.Backspace,
            contentDescription = Icons.Default.Backspace.name,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
private fun NunPadFingerprintButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    val isClicked by interactionSource.collectIsPressedAsState()

    val animatedShape by animateIntAsState(
        targetValue = if (isClicked) 25 else 50,
        label = "animatedShape"
    )

    Box(
        modifier = modifier
            .size(80.dp)
            .clip(shape = RoundedCornerShape(animatedShape))
            .background(color = MaterialTheme.colorScheme.secondary)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Default.Fingerprint,
            contentDescription = Icons.Default.Backspace.name,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
private fun NunPadConfirmButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    val isClicked by interactionSource.collectIsPressedAsState()

    val animatedShape by animateIntAsState(
        targetValue = if (isClicked) 25 else 50,
        label = "animatedShape"
    )

    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(animatedShape))
            .background(color = MaterialTheme.colorScheme.tertiary)
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = Icons.Default.Check.name,
            tint = MaterialTheme.colorScheme.onTertiary
        )

        Spacer(width = 2.dp)

        Text(
            text = stringResource(AuthStrings.confirm),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onTertiary,
        )
    }
}
