package com.s44khin.passwords.list.master

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.s44khin.common.api.di.injectViewModel
import com.s44khin.passwords.di.PasswordComponent
import com.s44khin.uikit.widgets.navigationBarsHeight

@Composable
fun PasswordsScreen() {
    val viewModel: PasswordsListViewModel = injectViewModel(PasswordComponent)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Magenta),
        contentPadding = PaddingValues(bottom = navigationBarsHeight + 16.dp)
    ) {
        repeat(100) {
            item {
                PasswordItem {
                    viewModel.onDetailClick()
                }
            }
        }
    }
}

@Composable
private fun PasswordItem(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = "Hello World")
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "s44khin")
    }
}