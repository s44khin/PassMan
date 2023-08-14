package com.s44khin.passwords.list.master

import androidx.lifecycle.ViewModel
import com.s44khin.common.api.repositories.ContextRepository
import javax.inject.Inject

internal class PasswordsListViewModel @Inject constructor(
    private val contextRepository: ContextRepository,
) : ViewModel() {

    fun onCopyClick() {
        contextRepository.copyToClipBoard(
            label = "label",
            text = "text",
        )
    }
}
