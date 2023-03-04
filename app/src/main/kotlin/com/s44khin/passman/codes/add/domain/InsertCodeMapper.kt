package com.s44khin.passman.codes.add.domain

import com.s44khin.passman.codes.add.presentation.data.CodeColor
import com.s44khin.passman.codes.data.dataBase.CodeEntity
import javax.inject.Inject

class InsertCodeMapper @Inject constructor() {

    operator fun invoke(secretCode: String, name: String, color: CodeColor) = CodeEntity(
        secretCode = secretCode,
        name = name,
        color = color.name
    )
}