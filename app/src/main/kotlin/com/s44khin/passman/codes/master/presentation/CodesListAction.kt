package com.s44khin.passman.codes.master.presentation

sealed class CodesListAction {

    object DeleteClick : CodesListAction()
    object AddClick : CodesListAction()
    data class StartEdit(val uid: String) : CodesListAction()
    object StopEdit : CodesListAction()
    data class CheckedClick(val uid: String) : CodesListAction()
}
