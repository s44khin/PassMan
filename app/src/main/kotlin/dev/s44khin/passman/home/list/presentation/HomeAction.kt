package dev.s44khin.passman.home.list.presentation

import dev.s44khin.passman.home.list.presentation.model.AccountVO

sealed class HomeAction {

    data class ItemClick(val account: AccountVO) : HomeAction()
    data class ItemLongClick(val account: AccountVO) : HomeAction()
    data object SearchClick : HomeAction()
    data object CreateClick : HomeAction()
    data object CreateSelectorExit : HomeAction()
}
