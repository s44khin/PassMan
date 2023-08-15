package com.s44khin.passman.presentation.data

import com.s44khin.codes.api.navigation.CodesNavigation
import com.s44khin.passwords.api.navigation.PasswordsNavigation

val bottomNavigationItems = setOf(
    PasswordsNavigation,
    CodesNavigation
)

val bottomNavigationRouts = setOf(
    PasswordsNavigation.route,
    CodesNavigation.route,
)