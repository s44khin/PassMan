package com.s44khin.passwords.list.master

import androidx.lifecycle.ViewModel
import com.s44khin.common.api.navigation.ScreenRouter
import com.s44khin.passwords.api.navigation.PasswordsNavigation
import javax.inject.Inject

internal class PasswordsListViewModel @Inject constructor(
    private val screenRouter: ScreenRouter,
) : ViewModel() {

    fun onDetailClick() {
        screenRouter.navigateTo(
            destination = PasswordsNavigation.Detail
        )
    }
}
