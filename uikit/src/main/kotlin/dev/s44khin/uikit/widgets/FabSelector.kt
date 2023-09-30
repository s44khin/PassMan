package dev.s44khin.uikit.widgets

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Immutable
data class FabSelectorItem(
    val icon: ImageVector,
    val onClick: () -> Unit,
)

@Composable
fun FabSelector(
    modifier: Modifier = Modifier,
    items: List<FabSelectorItem>,
    fab: FabSelectorItem,
    inSelect: Boolean,
    visible: Boolean,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items.forEach {
            AppAnimatedVisibility(visible = inSelect) {
                RoundedButton(
                    imageVector = it.icon,
                    onClick = it.onClick
                )
            }

            Spacer(height = 24.dp)
        }

        AppAnimatedVisibility(visible = visible) {
            val animatedRotation by animateFloatAsState(
                targetValue = if (inSelect) 135f else 0f,
                label = "animatedRotation"
            )

            FloatingActionButton(onClick = { fab.onClick() }) {
                Icon(
                    modifier = Modifier.rotate(animatedRotation),
                    imageVector = fab.icon,
                    contentDescription = fab.icon.name,
                )
            }
        }
    }
}
