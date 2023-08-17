package com.s44khin.passwords.list.master.presentation

import com.s44khin.common.api.core.base.BaseViewModel
import com.s44khin.common.api.navigation.ScreenRouter
import com.s44khin.passwords.api.navigation.PasswordsNavigation
import javax.inject.Inject

internal class PasswordsListViewModel @Inject constructor(
    private val screenRouter: ScreenRouter,
) : BaseViewModel<PasswordsListViewState, PasswordsListAction>(
    initState = PasswordsListViewState
) {

    override fun onAction(action: PasswordsListAction) {
        // TODO("Not yet implemented")
    }

    fun onDetailClick() {
        screenRouter.navigateTo(
            destination = PasswordsNavigation.Detail
        )
    }
}
