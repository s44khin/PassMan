package com.s44khin.passman.common.data

import com.s44khin.passman.common.data.dataBase.CodeEntity
import com.s44khin.passman.common.data.dataBase.CodesDataBase
import javax.inject.Inject

class CodesRepository @Inject constructor(
    private val codesDataBase: CodesDataBase
) {

    suspend fun getAllCodes() = codesDataBase.codesDao().getAll()

    suspend fun insertCodes(vararg codes: CodeEntity) = codesDataBase.codesDao().insertAll(*codes)

    suspend fun deleteById(vararg ids: String) = codesDataBase.codesDao().deleteByIds(*ids)

    suspend fun deleteAll() = codesDataBase.codesDao().deleteAll()

    suspend fun update(vararg ids: String) = codesDataBase.codesDao().update(*ids)
}
