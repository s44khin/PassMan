package com.s44khin.passman.codes.list.presentation.data

import androidx.compose.runtime.Immutable
import com.s44khin.uikit.theme.PrimaryColor

@Immutable
data class TotpItemVO(

    val uid: String,
    val code: String,
    val nextCode: String,
    val secretCode: String,
    val name: String,
    val color: PrimaryColor,
    val timer: Int,
    val checked: Boolean = false,
    val account: String?,
    val updateTimer: Int,
    val pinned: Boolean = false,
    val showNextCode: Boolean,
)
