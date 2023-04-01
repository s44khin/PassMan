package com.s44khin.passman.codes.master.presentation

import androidx.compose.runtime.Immutable
import com.s44khin.passman.codes.master.presentation.data.TotpItemVO
import com.s44khin.passman.util.mapIf

@Immutable
data class CodesListState(
    val mode: CodesListMode = CodesListMode.LOADING,
    val codes: List<TotpItemVO> = emptyList(),
    val inEdit: Boolean = false,
    val showNextCode: Boolean = true,
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

    fun toContent() = copy(mode = CodesListMode.CONTENT)

    fun toLoading() = copy(mode = CodesListMode.LOADING)

    fun toError() = copy(mode = CodesListMode.ERROR)
}

enum class CodesListMode {
    CONTENT, LOADING, ERROR
}
