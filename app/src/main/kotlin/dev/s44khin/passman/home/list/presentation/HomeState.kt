package dev.s44khin.passman.home.list.presentation

import androidx.compose.runtime.Immutable
import dev.s44khin.passman.home.list.presentation.model.AccountVO

@Immutable
data class HomeState(
    val list: List<AccountVO> = emptyList()
)
