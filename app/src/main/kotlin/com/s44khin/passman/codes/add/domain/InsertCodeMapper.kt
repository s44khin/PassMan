package com.s44khin.passman.codes.add.domain

import com.s44khin.passman.common.data.dataBase.CodeEntity
import com.s44khin.uikit.theme.PrimaryColor
import javax.inject.Inject

class InsertCodeMapper @Inject constructor() {

    fun map(
        secretCode: String,
        name: String,
        color: PrimaryColor,
        account: String?,
        description: String?,
        timer: Int,
        pinned: Boolean,
        showNextCode: Boolean,
    ) = CodeEntity(
        secretCode = secretCode,
        name = name,
        color = color.name,
        account = account,
        description = description,
        updateTimer = timer,
        pinned = pinned,
        showNextCode = showNextCode,
    )
}