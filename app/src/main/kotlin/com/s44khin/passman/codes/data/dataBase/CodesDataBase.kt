package com.s44khin.passman.codes.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CodeEntity::class], version = 1)
abstract class CodesDataBase : RoomDatabase() {

    abstract fun codesDao(): CodesDao
}
