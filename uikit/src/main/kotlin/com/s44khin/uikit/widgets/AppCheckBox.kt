package com.s44khin.uikit.widgets

import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.s44khin.uikit.theme.AppTheme

@Composable
fun AppRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: (() -> Unit),
) {
    RadioButton(
        modifier = modifier,
        selected = selected,
        colors = RadioButtonDefaults.colors(selectedColor = AppTheme.colors.primary),
        onClick = onClick,
    )
}
