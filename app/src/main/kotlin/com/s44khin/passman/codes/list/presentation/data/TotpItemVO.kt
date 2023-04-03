package com.s44khin.passman.codes.list.presentation.data

import androidx.compose.runtime.Immutable
import com.s44khin.passman.codes.add.presentation.data.CodeColor

@Immutable
data class TotpItemVO(

    val uid: String,
    val code: String,
    val nextCode: String,
    val secretCode: String,
    val name: String,
    val color: CodeColor,
    val timer: Int,
    val checked: Boolean = false,
    val account: String?,
    val updateTimer: Int,
)
