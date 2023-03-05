package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.s44khin.uikit.theme.AppTheme

@Composable
fun DebugButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            color = AppTheme.colors.textOnBackground,
        )

        Icon(
            imageVector = Icons.Rounded.ChevronRight,
            contentDescription = Icons.Rounded.ChevronRight.name,
            tint = AppTheme.colors.textOnBackgroundVariant,
        )
    }
}
