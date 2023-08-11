package com.s44khin.passman.settings.master.domain

import com.s44khin.passman.common.data.CodesRepository
import javax.inject.Inject

class DeleteAllUseCase @Inject constructor(
    private val repository: CodesRepository,
) {

    suspend fun execute() = repository.deleteAll()
}
