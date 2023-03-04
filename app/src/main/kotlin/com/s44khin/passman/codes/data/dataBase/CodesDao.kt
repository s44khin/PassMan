package com.s44khin.passman.codes.data.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CodesDao {

    @Query("SELECT * FROM CodeEntity")
    suspend fun getAll(): List<CodeEntity>

    @Insert
    suspend fun insertAll(vararg codes: CodeEntity)
}
