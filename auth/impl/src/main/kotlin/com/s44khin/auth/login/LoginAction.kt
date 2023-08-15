package com.s44khin.auth.login

internal sealed class LoginAction {

    data class OnClick(val char: Char) : LoginAction()
    data object Delete : LoginAction()
    data class ErrorEnd(val effect: LoginViewStateSideEffects) : LoginAction()
}
