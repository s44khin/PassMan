package com.s44khin.passman.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalViewModelFactoryProvider = staticCompositionLocalOf<AppViewModelFactory> {
    error("No AppViewModelFactory provided")
}

@Composable
fun ProvideViewModelFactory(
    appViewModelFactory: AppViewModelFactory,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalViewModelFactoryProvider provides appViewModelFactory, content = content)
}