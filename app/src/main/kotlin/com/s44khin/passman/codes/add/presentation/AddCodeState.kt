package com.s44khin.passman.codes.add.presentation

import androidx.compose.runtime.Immutable
import com.s44khin.passman.codes.add.presentation.data.CodeColor

@Immutable
data class AddCodeState(
    val name: String = "",
    val secretCode: String = "",
    val updateTimer: String = "30",
    val color: CodeColor = CodeColor.Blue,
    val account: String = "",
    val description: String = ""
) {

    fun toNewName(newName: String) = copy(name = newName)

    fun toNewSecretCode(newSecretCode: String) = copy(secretCode = newSecretCode)

    fun toNewColor(newColor: CodeColor) = copy(color = newColor)

    fun toNewAccount(newAccount: String) = copy(account = newAccount)

    fun toNewDescription(newDescription: String) = copy(description = newDescription)

    fun toNewTimer(timer: String) = copy(updateTimer = timer)
}
