package dev.s44khin.passman.home.list.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import dev.s44khin.uikit.widgets.Spacer

@Composable
fun HomeAccountItem(
    modifier: Modifier = Modifier,
    text: String,
    shape: RoundedCornerShape,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .clip(shape)
            .clickable { onClick.invoke() }
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(width = 4.dp)

        Spacer(
            modifier = Modifier
                .size(4.dp)
                .background(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    shape = CircleShape
                )
        )

        Spacer(width = 4.dp)

        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}