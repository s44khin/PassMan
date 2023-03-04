package com.s44khin.passman.codes.add.presentation

import androidx.compose.runtime.Immutable
import com.s44khin.passman.codes.add.presentation.data.CodeColor

@Immutable
data class AddCodeState(
    val name: String = "",
    val secretCode: String = "",
    val color: CodeColor = CodeColor.Blue,
) {

    fun toNewName(newName: String) = copy(name = newName)

    fun toNewSecretCode(newSecretCode: String) = copy(secretCode = newSecretCode)

    fun toNewColor(newColor: CodeColor) = copy(color = newColor)
}
