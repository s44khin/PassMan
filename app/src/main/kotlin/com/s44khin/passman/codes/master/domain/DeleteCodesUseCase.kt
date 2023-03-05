package com.s44khin.passman.codes.master.domain

import com.s44khin.passman.codes.data.CodesRepository
import javax.inject.Inject

class DeleteCodesUseCase @Inject constructor(
    private val repository: CodesRepository,
) {

    suspend operator fun invoke(vararg ids: String) = repository.deleteById(*ids)
}