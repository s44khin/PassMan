package com.s44khin.passman.codes.master.presentation

import androidx.compose.runtime.Immutable
import com.s44khin.passman.codes.master.presentation.data.TotpItemVO
import com.s44khin.passman.util.mapIf

@Immutable
data class CodesListState(
    val codes: List<TotpItemVO> = emptyList(),
    val inEdit: Boolean = false,
) {

    fun toNewList(newCodes: List<TotpItemVO>) = copy(codes = newCodes)

    fun toEdit(uid: String) = copy(
        inEdit = true,
        codes = codes.mapIf(
            predicate = { it.uid == uid },
            transform = { it.copy(checked = !it.checked) }
        )
    )

    fun stopEdit() = copy(
        inEdit = false,
        codes = codes.map {
            it.copy(checked = false)
        }
    )

    fun toChecked(uid: String): CodesListState {
        val newCodes = codes.mapIf(
            predicate = { it.uid == uid },
            transform = { it.copy(checked = !it.checked) }
        )

        return copy(
            codes = newCodes,
            inEdit = newCodes.any { it.checked }
        )
    }

    fun deleteChecked() = copy(
        codes = codes.filter { !it.checked },
        inEdit = false,
    )
}
