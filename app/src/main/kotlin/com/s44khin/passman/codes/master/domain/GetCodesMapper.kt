package com.s44khin.passman.codes.master.domain

import com.s44khin.passman.codes.add.presentation.data.CodeColor
import com.s44khin.passman.codes.master.presentation.data.CodeVO
import com.s44khin.passman.common.data.dataBase.CodeEntity
import javax.inject.Inject

class GetCodesMapper @Inject constructor() {

    fun map(codes: List<CodeEntity>) = codes.map {
        CodeVO(
            uid = it.uid,
            secretCode = it.secretCode,
            name = it.name,
            color = CodeColor.valueOf(it.color),
            account = it.account
        )
    }
}
