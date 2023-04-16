package com.s44khin.passman.codes.list.presentation

sealed class CodesListAction {

    data class CheckedClick(val uid: String) : CodesListAction()
    data class CopyToClipboard(val code: String) : CodesListAction()
    data class StartEdit(val uid: String) : CodesListAction()
    object ManuallyClick : CodesListAction()
    object QrCodeClick : CodesListAction()
    object DeleteClick : CodesListAction()
    object PinClick : CodesListAction()
    object StopEdit : CodesListAction()
    object OnAddClick : CodesListAction()
    object OnAddDisabled : CodesListAction()
}
