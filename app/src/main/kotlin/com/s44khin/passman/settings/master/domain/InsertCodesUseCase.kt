package com.s44khin.passman.settings.master.domain

import com.s44khin.passman.common.data.CodesRepository
import com.s44khin.passman.common.data.dataBase.CodeEntity
import javax.inject.Inject

class InsertCodesUseCase @Inject constructor(
    private val repository: CodesRepository
) {

    suspend fun execute(vararg codes: CodeEntity) = repository.insertCodes(*codes)
}