package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s44khin.passman.settings.master.presentation.data.ThemeVO
import com.s44khin.passman.settings.master.presentation.data.themeList
import com.s44khin.uikit.theme.AppTheme

@Composable
fun ThemeSelector(
    modifier: Modifier = Modifier,
    currentTheme: ThemeVO,
    onChangeTheme: (ThemeVO) -> Unit,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .border(
                width = 0.5.dp,
                color = AppTheme.colors.borderOnBackground,
                shape = RoundedCornerShape(24.dp)
            )
            .background(AppTheme.colors.background)
            .fillMaxWidth()
    ) {
        themeList.forEach { theme ->
            ThemeSelectorItem(
                modifier = Modifier.weight(1f),
                selected = theme == currentTheme,
                theme = theme,
                onClick = { onChangeTheme(theme) }
            )
        }
    }
}
