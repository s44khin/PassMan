package com.s44khin.auth.login

import androidx.lifecycle.ViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.s44khin.auth.api.navigation.AuthNavigation
import com.s44khin.auth.api.navigation.util.AuthStrings
import com.s44khin.common.api.core.ActionHandler
import com.s44khin.common.api.core.StateStore
import com.s44khin.common.api.core.StateStoreImpl
import com.s44khin.common.api.navigation.NavDestination
import com.s44khin.common.api.navigation.ScreenRouter
import com.s44khin.common.api.repositories.UserRepository
import com.s44khin.common.api.util.NativeText
import com.s44khin.passwords.api.navigation.PasswordsNavigation
import javax.inject.Inject

internal class LoginViewModel @Inject constructor(
    private val screenRouter: ScreenRouter,
    private val userRepository: UserRepository,
) : ViewModel(), ActionHandler<LoginAction>, StateStore<LoginViewState> by StateStoreImpl(
    initState = LoginViewState(
        isLogged = userRepository.isLogged,
    ),
) {

    private var savedPin: String? = null

    override fun onAction(action: LoginAction) = when (action) {
        is LoginAction.OnClick -> onClick(action.char)
        is LoginAction.Delete -> delete()
        is LoginAction.ErrorEnd -> errorEnd(action.effect)
    }

    private fun onClick(char: Char) {
        if (viewState.pin.length < 4) {
            viewState = viewState.toNewPin(char)
        }

        if (viewState.pin.length == 4) {
            if (savedPin == null) {
                savedPin = viewState.pin
                viewState = viewState.copy(
                    pin = "",
                    text = NativeText.Resource(AuthStrings.confirm_pin)
                )
            } else {
                if (savedPin == viewState.pin) {
                    userRepository.isLogged = true
                    screenRouter.navigateTo(destination = PasswordsNavigation) {
                        popUpTo(it.graph.findStartDestination().id) {
                            inclusive = true
                        }

                        launchSingleTop = true
                    }
                } else {
                    savedPin = null

                    viewState = viewState
                        .toWrongPin()
                        .copy(isError = true)
                }
            }
        }
    }

    private fun delete() {
        viewState = viewState.delete()
    }

    private fun errorEnd(effects: LoginViewStateSideEffects) {
        viewState.sideEffects.removeIf { it.uuid == effects.uuid }

        viewState = viewState.copy(
            isError = false,
            pin = "",
            text = NativeText.Resource(AuthStrings.enter_pin)
        )
    }
}