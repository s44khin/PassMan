package com.s44khin.passman.codes.add.presentation

import androidx.compose.runtime.Immutable
import com.s44khin.uikit.theme.PrimaryColor

@Immutable
data class AddCodeState(
    val name: String = "",
    val secretCode: String = "",
    val secretCodeInError: Boolean = false,
    val updateTimer: String = "30",
    val color: PrimaryColor = PrimaryColor.BLUE,
    val account: String = "",
    val description: String = "",
    val isPinned: Boolean = false,
    val showNextCode: Boolean = true,
    val showNextCodeAvailable: Boolean = false,
) {

    fun toNewName(newName: String) = copy(name = newName)

    fun toNewSecretCode(newSecretCode: String) = copy(secretCode = newSecretCode)

    fun toNewColor(newColor: PrimaryColor) = copy(color = newColor)

    fun toNewAccount(newAccount: String) = copy(account = newAccount)

    fun toNewDescription(newDescription: String) = copy(description = newDescription)

    fun toNewTimer(timer: String) = copy(updateTimer = timer)

    fun toChangeIsPinned() = copy(isPinned = !isPinned)

    fun toChangeShowNextCode() = copy(showNextCode = !showNextCode)

    fun toSecretCodeError() = copy(
        secretCodeInError = true
    )

    fun toSecretCodeIsNotError() = copy(
        secretCodeInError = false,
    )
}
