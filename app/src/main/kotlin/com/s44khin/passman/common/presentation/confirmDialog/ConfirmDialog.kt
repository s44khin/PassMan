package com.s44khin.passman.common.presentation.confirmDialog

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppButtonMedium
import com.s44khin.uikit.widgets.AppButtonMediumOutlined
import com.s44khin.uikit.widgets.Spacer

@Immutable
data class ConfirmDialogButton(
    val label: String,
    val onClick: () -> Unit,
)

@Composable
fun ColumnScope.ConfirmDialog(
    title: String,
    subtitle: String,
    firstButton: ConfirmDialogButton,
    secondButton: ConfirmDialogButton,
) {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = title,
        fontSize = 22.sp,
        color = AppTheme.colors.textOnBackground,
        fontWeight = FontWeight.Bold,
    )

    Spacer(height = 2.dp)

    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = subtitle,
        fontSize = 18.sp,
        color = AppTheme.colors.textOnBackground,
    )

    Spacer(height = 24.dp)

    AppButtonMedium(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        label = firstButton.label,
        shape = RoundedCornerShape(topStart = AppTheme.shapes.smallValue, topEnd = AppTheme.shapes.smallValue),
        onClick = firstButton.onClick
    )

    Spacer(4.dp)

    AppButtonMediumOutlined(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        label = secondButton.label,
        shape = RoundedCornerShape(bottomStart = AppTheme.shapes.smallValue, bottomEnd = AppTheme.shapes.smallValue),
        onClick = secondButton.onClick
    )

    Spacer(20.dp)
}
