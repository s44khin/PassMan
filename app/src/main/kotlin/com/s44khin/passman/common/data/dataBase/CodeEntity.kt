package com.s44khin.passman.common.data.dataBase

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
    @ColumnInfo(name = "account") val account: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "update_timer") val updateTimer: Int,
    @ColumnInfo(name = "pinned") val pinned: Boolean = false,
    @ColumnInfo(name = "show_next_code") val showNextCode: Boolean,
)
