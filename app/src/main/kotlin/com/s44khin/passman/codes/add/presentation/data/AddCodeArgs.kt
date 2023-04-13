package com.s44khin.passman.codes.add.presentation.data

data class AddCodeArgs(
    val email: String,
    val code: String,
    val name: String,
    val period: Int,
)
