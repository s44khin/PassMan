package com.s44khin.passman.codes.add.presentation.data

import com.s44khin.passman.codes.add.presentation.AddCodeState

val AddCodeState.buttonIsEnabled: Boolean
    get() = name.isNotEmpty() && secretCode.isNotEmpty() && updateTimer.isNotEmpty() && !secretCodeInError

val AddCodeState.isEmpty: Boolean
    get() = name.isEmpty() && secretCode.isEmpty() && account.isEmpty() && description.isEmpty() && !isPinned &&
            showNextCode

val AddCodeState.isNotEmpty: Boolean get() = !isEmpty
