package com.s44khin.passman.codes.data.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class CodeEntity(
    @PrimaryKey val uid: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "secret_code") val secretCode: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "color") val color: String,
)
