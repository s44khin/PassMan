package com.s44khin.passwords

import androidx.compose.runtime.Composable
import com.s44khin.common.api.di.injectViewModel
import com.s44khin.passwords.di.PasswordComponent
import com.s44khin.passwords.list.master.PasswordsListViewModel

@Composable
fun PasswordsScreen() {
    val viewModel: PasswordsListViewModel = injectViewModel(PasswordComponent)
}