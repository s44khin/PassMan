package com.s44khin.passman.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import com.s44khin.passman.di.AppViewModelFactory
import com.s44khin.passman.di.appComponent
import com.s44khin.uikit.theme.DsTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navHostController: NavHostController

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    private val viewModel: MainViewModel by viewModels(
        factoryProducer = { appViewModelFactory }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent.inject(this)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val viewState by viewModel.state.collectAsState()

            DsTheme {
                MainScreen(
                    viewState = viewState,
                    navHostController = navHostController
                )
            }
        }
    }
}
