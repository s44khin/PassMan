package com.s44khin.passman.codes.list.domain

import com.s44khin.passman.codes.list.presentation.data.CodeVO
import com.s44khin.passman.common.data.dataBase.CodeEntity
import com.s44khin.uikit.theme.PrimaryColor
import javax.inject.Inject

class GetCodesMapper @Inject constructor() {

    fun map(codes: List<CodeEntity>) = codes.map {
        CodeVO(
            uid = it.uid,
            secretCode = it.secretCode,
            name = it.name,
            color = PrimaryColor.valueOf(it.color),
            account = it.account,
            updateTimer = it.updateTimer,
            pinned = it.pinned,
            showNextCode = it.showNextCode,
        )
    }
}
