package com.s44khin.passman.codes.add.presentation

import androidx.lifecycle.viewModelScope
import com.s44khin.passman.codes.add.domain.InsertCodeUseCase
import com.s44khin.passman.codes.common.Constants
import com.s44khin.passman.core.BaseViewModel
import com.s44khin.passman.navigation.ScreenRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddCodeViewModel @Inject constructor(
    private val insertCodeUseCase: InsertCodeUseCase,
    private val screenRouter: ScreenRouter,
) : BaseViewModel<AddCodeState, AddCodeAction>(
    initState = AddCodeState()
) {

    override fun onAction(action: AddCodeAction) = when (action) {
        is AddCodeAction.BackClick -> screenRouter.back()
        is AddCodeAction.ChangeColor -> viewState = viewState.toNewColor(action.newColor)
        is AddCodeAction.ChangeName -> viewState = viewState.toNewName(action.newName)
        is AddCodeAction.ChangeSecretCode -> viewState = viewState.toNewSecretCode(action.newCode)
        is AddCodeAction.SaveClick -> saveClick()
    }

    private fun saveClick() {
        viewModelScope.launch(Dispatchers.IO) {
            insertCodeUseCase(
                secretCode = viewState.secretCode,
                name = viewState.name,
                color = viewState.color
            )

            withContext(Dispatchers.Main) {
                screenRouter.backWithSignal(Constants.UPDATE_CODES_LIST)
            }
        }
    }
}