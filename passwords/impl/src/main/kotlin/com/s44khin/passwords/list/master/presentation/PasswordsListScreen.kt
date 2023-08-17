package com.s44khin.passwords.list.master.presentation

import androidx.compose.runtime.Composable
import com.s44khin.common.api.core.base.screen.Screen
import com.s44khin.common.api.di.injectViewModel
import com.s44khin.passwords.di.PasswordComponent
import com.s44khin.passwords.list.master.presentation.widgets.PasswordsListContent

@Composable
internal fun PasswordsListScreen() = Screen(
    viewModel = PasswordComponent.injectViewModel<PasswordsListViewModel, PasswordComponent>(),
    content = { PasswordsListContent() }
)
