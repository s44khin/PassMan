package com.s44khin.passman.codes.list.domain

import com.s44khin.passman.common.data.CodesRepository
import javax.inject.Inject

class GetCodesUseCase @Inject constructor(
    private val mapper: GetCodesMapper,
    private val repository: CodesRepository,
) {

    suspend fun execute() = mapper.map(
        codes = repository.getAllCodes()
    )
}
