package com.s44khin.passman

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s44khin.uikit.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = AppTheme.colors.rootBackground)
                ) {
                    Box(
                        modifier = Modifier
                            .background(AppTheme.colors.background)
                            .align(Alignment.Center)
                            .size(150.dp)
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = "Card"
                        )
                    }
                }
            }
        }
    }
}