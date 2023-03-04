package com.s44khin.passman.codes.master.domain

import com.s44khin.passman.codes.data.CodesRepository
import javax.inject.Inject

class GetCodesUseCase @Inject constructor(
    private val repository: CodesRepository,
    private val mapper: GetCodesMapper,
) {

    suspend operator fun invoke() = mapper(
        codes = repository.getAllCodes()
    )
}