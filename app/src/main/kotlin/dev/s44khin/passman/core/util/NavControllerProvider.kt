package dev.s44khin.passman.core.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController

val LocalNavController = compositionLocalOf<NavController> { error("No NavHost provided") }

@Composable
fun NavController.Provide(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalNavController provides this,
        content = content,
    )
}
