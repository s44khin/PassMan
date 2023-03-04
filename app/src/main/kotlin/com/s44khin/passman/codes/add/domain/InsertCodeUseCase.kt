package com.s44khin.passman.codes.add.domain

import com.s44khin.passman.codes.add.presentation.data.CodeColor
import com.s44khin.passman.codes.data.CodesRepository
import javax.inject.Inject

class InsertCodeUseCase @Inject constructor(
    private val repository: CodesRepository,
    private val mapper: InsertCodeMapper,
) {

    suspend operator fun invoke(secretCode: String, name: String, color: CodeColor) = repository.insertCodes(
        mapper(secretCode, name, color)
    )
}