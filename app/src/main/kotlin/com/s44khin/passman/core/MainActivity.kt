package com.s44khin.passman.core

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import com.s44khin.passman.di.extensions.appComponent
import com.s44khin.passman.navigation.AppBottomNav
import com.s44khin.passman.navigation.AppNavHost
import com.s44khin.uikit.theme.AppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navHostController: NavHostController

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    @Inject
    lateinit var appStorage: AppStorage

    @Inject
    lateinit var cleanUpUseCase: CleanUpUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val rememberNavHostController = remember { navHostController }
            val rememberViewModelFactory = remember { appViewModelFactory }

            ProvideViewModelFactory(rememberViewModelFactory) {
                AppTheme {
                    AppBottomNav(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        navController = rememberNavHostController
                    )

                    AppNavHost(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .fillMaxSize(),
                        navHostController = rememberNavHostController
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        lifecycleScope.launch(Dispatchers.IO) {
            cleanUpUseCase.execute()
        }

        super.onDestroy()
    }
}