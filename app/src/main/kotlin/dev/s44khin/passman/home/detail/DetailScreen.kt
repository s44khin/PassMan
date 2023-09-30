package dev.s44khin.passman.home.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen() {
    Box(
        modifier = Modifier
            .shadow(elevation = 16.dp)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {

    }
}