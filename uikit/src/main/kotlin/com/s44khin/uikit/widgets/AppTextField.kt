package com.s44khin.uikit.widgets

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = AppTheme.colors.primary,
            focusedBorderColor = AppTheme.colors.primary,
            cursorColor = AppTheme.colors.primary,
        )
    )
}