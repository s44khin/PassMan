package com.s44khin.passman.codes.add.domain

import com.s44khin.passman.common.data.CodesRepository
import com.s44khin.uikit.theme.PrimaryColor
import javax.inject.Inject

class InsertCodeUseCase @Inject constructor(
    private val repository: CodesRepository,
    private val mapper: InsertCodeMapper,
) {

    suspend fun execute(
        secretCode: String,
        name: String,
        color: PrimaryColor,
        account: String?,
        description: String?,
        timer: Int,
        pinned: Boolean,
        showNextCode: Boolean
    ) = repository.insertCodes(
        mapper.map(secretCode, name, color, account, description, timer, pinned, showNextCode)
    )
}