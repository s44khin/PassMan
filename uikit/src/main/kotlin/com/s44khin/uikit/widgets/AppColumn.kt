package com.s44khin.uikit.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme

sealed class AppColumnItemType {

    data class RadioButton(
        val label: String,
        val isSelected: Boolean,
        val onClick: () -> Unit
    ) : AppColumnItemType()

    data class Switch(
        val label: String,
        val isSelected: Boolean,
        val onClick: () -> Unit,
    ) : AppColumnItemType()


    data class Chevron(
        val label: String,
        val onClick: () -> Unit
    ) : AppColumnItemType()

    data class TextField(
        val label: String,
        val value: String,
        val inError: Boolean = false,
        val onValueChange: (String) -> Unit,
    ) : AppColumnItemType()
}

@Composable
fun AppColumn(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .border(
                width = 0.5.dp,
                color = AppTheme.colors.divider,
                shape = RoundedCornerShape(24.dp)
            )
            .clip(RoundedCornerShape(24.dp))
            .fillMaxWidth()
    ) {
        content()
    }
}

@Composable
fun AppColumn(
    modifier: Modifier = Modifier,
    content: List<AppColumnItemType>
) {
    AppColumn(modifier = modifier) {
        content.forEachIndexed { index, appColumnItemType ->
            when (appColumnItemType) {
                is AppColumnItemType.Chevron -> Row(
                    modifier = Modifier
                        .clickable { appColumnItemType.onClick() }
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = appColumnItemType.label,
                        color = AppTheme.colors.textOnBackground,
                    )

                    Icon(
                        imageVector = Icons.Rounded.ChevronRight,
                        contentDescription = Icons.Rounded.ChevronRight.name,
                        tint = AppTheme.colors.textOnBackgroundVariant,
                    )
                }

                is AppColumnItemType.RadioButton -> Row(
                    modifier = Modifier
                        .clickable { appColumnItemType.onClick() }
                        .padding(start = 16.dp, top = 6.dp, end = 6.dp, bottom = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = appColumnItemType.label,
                        color = AppTheme.colors.textOnBackground
                    )

                    AppRadioButton(
                        selected = appColumnItemType.isSelected,
                        onClick = appColumnItemType.onClick
                    )
                }

                is AppColumnItemType.Switch -> Row(
                    modifier = Modifier
                        .clickable { appColumnItemType.onClick() }
                        .padding(start = 16.dp, top = 6.dp, end = 16.dp, bottom = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = appColumnItemType.label,
                        color = AppTheme.colors.textOnBackground
                    )

                    AppSwitch(
                        checked = appColumnItemType.isSelected,
                        onCheckedChange = appColumnItemType.onClick
                    )
                }

                is AppColumnItemType.TextField -> AppTextField(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(0.dp),
                    borderColor = AppTheme.colors.background,
                    contentColor = if (appColumnItemType.inError) {
                        AppTheme.colors.error
                    } else {
                        AppTheme.colors.textOnBackground
                    },
                    value = appColumnItemType.value,
                    label = appColumnItemType.label,
                    onValueChange = { appColumnItemType.onValueChange(it) },
                )
            }

            if (index != content.lastIndex) {
                AppDivider(startIndent = 12.dp)
            }
        }
    }
}
