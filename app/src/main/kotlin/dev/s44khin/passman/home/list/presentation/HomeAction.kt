package dev.s44khin.passman.home.list.presentation

import dev.s44khin.passman.core.util.UID

sealed class HomeAction {

    data class ItemClick(val uid: UID) : HomeAction()
}