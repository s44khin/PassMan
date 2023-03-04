package com.s44khin.passman.settings.master.presentation.widgets

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.settings.master.presentation.data.ThemeVO
import com.s44khin.passman.settings.master.presentation.data.themeList
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.Spacer

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

@Composable
private fun RowScope.ThemeSelectorItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    theme: ThemeVO,
    onClick: () -> Unit
) {
    val animatedColor by animateColorAsState(
        targetValue = if (selected) AppTheme.colors.primary else AppTheme.colors.textOnBackgroundVariant
    )

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .clickable { onClick() }
            .padding(vertical = 16.dp)
    ) {
        Icon(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            imageVector = theme.icon,
            tint = animatedColor,
            contentDescription = theme.icon.name
        )

        Spacer(height = 4.dp)

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(theme.label),
            color = animatedColor,
        )
    }
}