package com.s44khin.passman.common.data.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CodesDao {

    @Query("SELECT * FROM CodeEntity")
    suspend fun getAll(): List<CodeEntity>

    @Insert
    suspend fun insertAll(vararg codes: CodeEntity)

    @Query("DELETE FROM CodeEntity WHERE uid IN (:ids)")
    suspend fun deleteByIds(vararg ids: String)

    @Query("DELETE FROM CodeEntity")
    suspend fun deleteAll()
}
