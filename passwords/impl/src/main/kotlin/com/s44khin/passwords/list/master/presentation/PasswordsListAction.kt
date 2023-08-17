package com.s44khin.passwords.list.master.presentation

sealed class PasswordsListAction {

    data object OnItemClick : PasswordsListAction()
    data object OnAddClick : PasswordsListAction()
    data object SearchClick : PasswordsListAction()
}

