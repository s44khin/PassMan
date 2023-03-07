package com.s44khin.passman.codes.master.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronRight
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.QrCode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.passman.R
import com.s44khin.passman.codes.master.presentation.CodesListAction
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.RootSpacer

@Composable
fun ColumnScope.AddDialog(
    qrCode: () -> Unit,
    manually: () -> Unit,
) {
    RootSpacer(height = 16.dp)

    AddDialogItem(
        icon = Icons.Rounded.QrCode,
        contentDescription = Icons.Rounded.QrCode.name,
        title = stringResource(R.string.settings_add_qr_code),
        onClick = {}
    )

    Divider(startIndent = 16.dp)

    AddDialogItem(
        icon = Icons.Rounded.List,
        contentDescription = Icons.Rounded.QrCode.name,
        title = stringResource(R.string.settings_add_manually),
        onClick = { manually() }
    )
}

@Composable
private fun AddDialogItem(
    icon: ImageVector,
    title: String,
    contentDescription: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(48.dp)
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = AppTheme.colors.textOnBackground,
        )

        RootSpacer(width = 8.dp)

        Text(
            modifier = Modifier.weight(1f),
            text = title,
            color = AppTheme.colors.textOnBackground,
        )

        Icon(
            imageVector = Icons.Rounded.ChevronRight,
            contentDescription = Icons.Rounded.ChevronRight.name,
            tint = AppTheme.colors.textOnBackgroundVariant,
        )
    }
}
