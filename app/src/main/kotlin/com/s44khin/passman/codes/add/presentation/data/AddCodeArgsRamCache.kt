package com.s44khin.passman.codes.add.presentation.data

import com.s44khin.passman.core.Clearable
import com.s44khin.passman.di.AppScope
import javax.inject.Inject

@AppScope
class AddCodeArgsRamCache @Inject constructor() : Clearable {

    var args: AddCodeArgs? = null
        get() = field.apply { field = null }

    override fun clean() {
        args = null
    }
}