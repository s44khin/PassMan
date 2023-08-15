package com.s44khin.auth.login

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.s44khin.auth.api.navigation.util.AuthStrings
import com.s44khin.common.api.core.SideEffect
import com.s44khin.common.api.util.NativeText

@Immutable
internal data class LoginViewState(

    val isLogged: Boolean,
    val pin: String = "",
    val text: NativeText = NativeText.Resource(AuthStrings.enter_pin),
    val sideEffects: SnapshotStateList<LoginViewStateSideEffects> = mutableStateListOf(),
    val isError: Boolean = false,
) {

    fun toNewPin(char: Char) = copy(
        pin = pin + char
    )

    fun delete() = copy(
        pin = pin.dropLast(1)
    )

    fun toWrongPin() = copy(
        sideEffects = mutableStateListOf(LoginViewStateSideEffects.WrongPin())
    )
}

@Immutable
internal sealed class LoginViewStateSideEffects : SideEffect() {

    class WrongPin : LoginViewStateSideEffects()
}