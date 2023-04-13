package com.s44khin.passman.codes.list.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.Spacer

@Composable
fun EditPopup(
    modifier: Modifier = Modifier,
    onDeleteClick: () -> Unit,
    onPinClick: () -> Unit,
    onCloseClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .background(
                color = AppTheme.colors.background,
                shape = AppTheme.shapes.small
            )
            .clip(AppTheme.shapes.small)
            .border(
                width = 0.5.dp,
                color = AppTheme.colors.divider,
                shape = AppTheme.shapes.small
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Spacer(width = 8.dp)

        IconButton(
            modifier = Modifier.padding(vertical = 4.dp),
            onClick = { onPinClick() }
        ) {
            Icon(
                imageVector = Icons.Outlined.PushPin,
                contentDescription = Icons.Outlined.PushPin.name,
                tint = AppTheme.colors.textOnBackgroundVariant,
            )
        }

        Spacer(width = 4.dp)

        IconButton(
            modifier = Modifier.padding(vertical = 4.dp),
            onClick = { onPinClick() }
        ) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = Icons.Outlined.Delete.name,
                tint = AppTheme.colors.textOnBackgroundVariant,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            modifier = Modifier.padding(vertical = 4.dp),
            onClick = { onPinClick() }
        ) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = Icons.Rounded.Close.name,
                tint = AppTheme.colors.textOnBackgroundVariant,
            )
        }

        Spacer(width = 8.dp)
    }
}