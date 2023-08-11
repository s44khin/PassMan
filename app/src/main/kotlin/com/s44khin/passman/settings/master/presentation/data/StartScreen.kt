package com.s44khin.passman.settings.master.presentation.data

enum class StartScreen {

    Codes, Passwords;

    fun isCodes() = this == Codes

    fun isPasswords() = this == Passwords
}
