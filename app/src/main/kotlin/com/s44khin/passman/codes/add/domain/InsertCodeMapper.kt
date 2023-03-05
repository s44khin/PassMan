package com.s44khin.passman.codes.add.domain

import com.s44khin.passman.codes.add.presentation.data.CodeColor
import com.s44khin.passman.common.data.dataBase.CodeEntity
import javax.inject.Inject

class InsertCodeMapper @Inject constructor() {

    fun map(
        secretCode: String,
        name: String,
        color: CodeColor,
        account: String?,
        description: String?,
        timer: Int,
    ) = CodeEntity(
        secretCode = secretCode,
        name = name,
        color = color.name,
        account = account,
        description = description,
        updateTimer = timer
    )
}