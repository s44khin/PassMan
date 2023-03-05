package com.s44khin.passman.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.s44khin.passman.di.extensions.appComponent
import com.s44khin.passman.navigation.AppBottomNav
import com.s44khin.passman.navigation.AppNavHost
import com.s44khin.passman.settings.master.presentation.SettingsViewModel
import com.s44khin.passman.settings.master.presentation.data.ThemeVO
import com.s44khin.uikit.theme.AppTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navHostController: NavHostController

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    @Inject
    lateinit var appStorage: AppStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val rememberNavHostController = remember {
                navHostController
            }

            val theme: ThemeVO = remember {
                val str = appStorage.getString(key = SettingsViewModel.THEME_KEY, ThemeVO.System.name)
                ThemeVO.valueOf(str)
            }

            ProvideViewModelFactory(appViewModelFactory) {
                AppTheme(
                    isDarkTheme = when (theme) {
                        ThemeVO.System -> isSystemInDarkTheme()
                        ThemeVO.Dark -> true
                        ThemeVO.Light -> false
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = AppTheme.colors.rootBackground)
                    ) {
                        AppNavHost(modifier = Modifier.weight(1f), navHostController = navHostController)
                        AppBottomNav(rememberNavHostController)
                    }
                }
            }
        }
    }
}