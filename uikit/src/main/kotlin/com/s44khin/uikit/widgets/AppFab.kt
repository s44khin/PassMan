package com.s44khin.uikit.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme

data class AppFabData(
    val icon: ImageVector,
    val onClick: () -> Unit,
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BoxScope.AppFab(
    modifier: Modifier = Modifier,
    isOpen: Boolean = false,
    visible: Boolean = true,
    appFabDataList: List<AppFabData> = emptyList(),
    mainFabContent: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .align(Alignment.BottomEnd)
            .padding(end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        appFabDataList.forEach { appFabData ->
            AnimatedVisibility(
                visible = isOpen,
                enter = scaleIn() + fadeIn(),
                exit = scaleOut() + fadeOut()
            ) {
                FloatingActionButton(
                    modifier = Modifier.size(40.dp),
                    backgroundColor = AppTheme.colors.primary,
                    contentColor = AppTheme.colors.textOnPrimary,
                    onClick = { appFabData.onClick() }
                ) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = appFabData.icon,
                        contentDescription = appFabData.icon.name,
                    )
                }
            }

            Spacer(height = 24.dp)
        }

        AnimatedVisibility(
            modifier = Modifier.padding(bottom = 24.dp),
            visible = visible,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            mainFabContent()
        }
    }
}
