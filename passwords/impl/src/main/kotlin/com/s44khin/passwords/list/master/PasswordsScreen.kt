package com.s44khin.passwords.list.master

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.s44khin.common.api.di.injectViewModel
import com.s44khin.passwords.di.PasswordComponent

@Composable
fun PasswordsScreen() {
    val viewModel: PasswordsListViewModel = injectViewModel(PasswordComponent)

    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { viewModel.onCopyClick() }, modifier = Modifier.align(Alignment.Center)) {
            Text(text = "copy")
        }
    }
}