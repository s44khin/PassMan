package com.s44khin.passman.codes.list.presentation.data

import androidx.compose.runtime.Immutable
import com.s44khin.uikit.theme.PrimaryColor

@Immutable
data class CodeVO(

    val uid: String,
    val secretCode: String,
    val name: String,
    val color: PrimaryColor,
    val account: String?,
    val updateTimer: Int,
    val pinned: Boolean,
    val showNextCode: Boolean,
)
