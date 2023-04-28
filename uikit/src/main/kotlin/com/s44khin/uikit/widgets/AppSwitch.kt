package com.s44khin.uikit.widgets

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.s44khin.uikit.theme.AppTheme

@Composable
fun AppSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: () -> Unit,
) {
    Switch(
        modifier = modifier,
        colors = SwitchDefaults.colors(
            uncheckedTrackColor = AppTheme.colors.background,
            checkedTrackColor = AppTheme.colors.primary,
        ),
        checked = checked,
        onCheckedChange = { onCheckedChange() }
    )
}