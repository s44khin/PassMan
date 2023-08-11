package com.s44khin.passman.navigation

import android.content.Context
import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator

fun createNavController(context: Context) = NavHostController(context).apply {
    navigatorProvider.addNavigator(ComposeNavigator())
    navigatorProvider.addNavigator(DialogNavigator())
}
