package dev.s44khin.uikit.widgets

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class AppTopNavBarAction(
    val icon: ImageVector,
    val onClick: () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopNavBar(
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: AppTopNavBarAction? = null,
    actions: List<AppTopNavBarAction>? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = title) },
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            AppAnimatedVisibility(visible = navigationIcon != null) {
                if (navigationIcon != null) {
                    IconButton(onClick = { navigationIcon.onClick.invoke() }) {
                        Icon(
                            imageVector = navigationIcon.icon,
                            contentDescription = navigationIcon.icon.name
                        )
                    }
                }
            }
        },
        actions = {
            actions?.forEach { action ->
                IconButton(onClick = { action.onClick.invoke() }) {
                    Icon(
                        imageVector = action.icon,
                        contentDescription = action.icon.name
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopNavBar(
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: AppTopNavBarAction? = null,
    actions: @Composable RowScope.() -> Unit,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = title) },
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            AppAnimatedVisibility(visible = navigationIcon != null) {
                if (navigationIcon != null) {
                    IconButton(onClick = { navigationIcon.onClick.invoke() }) {
                        Icon(
                            imageVector = navigationIcon.icon,
                            contentDescription = navigationIcon.icon.name
                        )
                    }
                }
            }
        },
        actions = actions
    )
}
