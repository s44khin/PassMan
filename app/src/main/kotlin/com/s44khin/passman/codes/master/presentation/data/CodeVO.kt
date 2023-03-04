package com.s44khin.passman.codes.master.presentation.data

import androidx.compose.runtime.Immutable
import com.s44khin.passman.codes.add.presentation.data.CodeColor

@Immutable
data class CodeVO(
    val uid: String,
    val secretCode: String,
    val name: String,
    val color: CodeColor,
)