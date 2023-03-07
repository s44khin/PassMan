package com.s44khin.passman.codes.master.presentation

sealed class CodesListAction {

    data class CheckedClick(val uid: String) : CodesListAction()
    data class CopyToClipboard(val code: String) : CodesListAction()
    data class StartEdit(val uid: String) : CodesListAction()
    object ManuallyClick : CodesListAction()
    object QrCodeClick : CodesListAction()
    object DeleteClick : CodesListAction()
    object StopEdit : CodesListAction()
}
