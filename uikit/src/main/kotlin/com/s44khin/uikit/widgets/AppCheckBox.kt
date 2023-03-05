package com.s44khin.uikit.widgets

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.s44khin.uikit.theme.AppTheme

@Composable
fun AppCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
) {
    Checkbox(
        modifier = modifier,
        checked = checked,
        colors = CheckboxDefaults.colors(checkedColor = AppTheme.colors.primary),
        onCheckedChange = onCheckedChange,
    )
}
