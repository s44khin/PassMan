package com.s44khin.passman.codes.add.presentation

import com.s44khin.passman.codes.add.presentation.data.CodeColor

sealed class AddCodeAction {

    data class ChangTimer(val newTimer: String) : AddCodeAction()
    data class ChangeAccount(val newAccount: String) : AddCodeAction()
    data class ChangeColor(val newColor: CodeColor) : AddCodeAction()
    data class ChangeDescription(val newDescription: String) : AddCodeAction()
    data class ChangeName(val newName: String) : AddCodeAction()
    data class ChangeSecretCode(val newCode: String) : AddCodeAction()
    object BackClick : AddCodeAction()
    object ChangePinned : AddCodeAction()
    object ChangeShowNextCode : AddCodeAction()
    object SaveClick : AddCodeAction()
}
