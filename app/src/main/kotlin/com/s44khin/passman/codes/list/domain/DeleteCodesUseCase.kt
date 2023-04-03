package com.s44khin.passman.codes.list.domain

import com.s44khin.passman.common.data.CodesRepository
import javax.inject.Inject

class DeleteCodesUseCase @Inject constructor(
    private val repository: CodesRepository,
) {

    suspend fun execute(vararg ids: String) = repository.deleteById(*ids)
}
