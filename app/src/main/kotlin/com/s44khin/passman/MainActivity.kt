package com.s44khin.passman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.BottomNav
import com.s44khin.uikit.widgets.BottomNavItem

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = AppTheme.colors.rootBackground)
                ) {
                    Spacer(modifier = Modifier.weight(1f))

                    BottomNav {
                        BottomNavItem(
                            selected = true,
                            icon = Icons.Rounded.Home,
                            label = "Home",
                            onClick = {}
                        )

                        BottomNavItem(
                            selected = true,
                            icon = Icons.Rounded.Home,
                            label = "Home",
                            onClick = {}
                        )

                        BottomNavItem(
                            selected = true,
                            icon = Icons.Rounded.Home,
                            label = "Home",
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}