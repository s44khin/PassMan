package dev.s44khin.passman.home.list.presentation.model

import androidx.compose.runtime.Immutable
import dev.s44khin.passman.core.util.UID

@Immutable
data class AccountVO(
    val uid: UID = UID.randomUID(),
)
