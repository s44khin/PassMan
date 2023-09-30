package dev.s44khin.passman.home.list.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.s44khin.passman.R
import dev.s44khin.passman.home.list.presentation.model.AccountVO
import dev.s44khin.uikit.layouts.SurfaceRow
import dev.s44khin.uikit.widgets.Spacer

@Composable
fun HomeAccountItem(
    modifier: Modifier = Modifier,
    accountVO: AccountVO,
    shape: RoundedCornerShape,
    onClick: () -> Unit,
) {
    SurfaceRow(
        modifier = modifier.clickable { onClick.invoke() },
        tonalElevation = 8.dp,
        shape = shape,
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        Spacer(width = 16.dp)

        Spacer(
            modifier = Modifier
                .size(12.dp)
                .background(
                    color = accountVO.color.value,
                    shape = CircleShape
                )
        )

        Spacer(width = 16.dp)

        Column {
            Text(
                text = stringResource(
                    id = R.string.home_account_label_dot,
                    accountVO.accountName.resolve(),
                    accountVO.email.resolve()
                ),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleSmall,
            )

            Spacer(height = 4.dp)

            Text(
                text = "123 321",
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.displayLarge,
            )
        }
    }
}