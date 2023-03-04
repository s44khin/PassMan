package com.s44khin.passman.codes.master.presentation

import androidx.compose.runtime.Immutable
import com.s44khin.passman.codes.master.presentation.data.TotpItemVO

@Immutable
data class CodesListState(
    val codes: List<TotpItemVO> = emptyList()
) {

    fun toNewList(newCodes: List<TotpItemVO>) = copy(codes = newCodes)
}
