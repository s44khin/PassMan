package com.s44khin.passman.codes.master.presentation

sealed class CodesListAction {

    data class CheckedClick(val uid: String) : CodesListAction()
    data class StartEdit(val uid: String) : CodesListAction()
    object AddClick : CodesListAction()
    object DeleteClick : CodesListAction()
    object StopEdit : CodesListAction()
}
