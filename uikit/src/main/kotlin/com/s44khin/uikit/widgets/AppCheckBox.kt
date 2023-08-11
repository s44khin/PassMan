package com.s44khin.uikit.widgets

import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
        colors = RadioButtonDefaults.colors(
            selectedColor = AppTheme.colors.primary,
            unselectedColor = AppTheme.colors.textOnBackgroundVariant,
        ),
        onClick = onClick,
    )
}
