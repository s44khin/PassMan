package com.s44khin.passman.codes.data

import com.s44khin.passman.codes.data.dataBase.CodeEntity
import com.s44khin.passman.codes.data.dataBase.CodesDataBase
import javax.inject.Inject

class CodesRepository @Inject constructor(
    private val codesDataBase: CodesDataBase
) {

    suspend fun getAllCodes() = codesDataBase.codesDao().getAll()

    suspend fun insertCodes(vararg codes: CodeEntity) = codesDataBase.codesDao().insertAll(*codes)
}