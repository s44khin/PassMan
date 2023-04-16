package com.s44khin.passman.codes.add.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s44khin.passman.codes.add.domain.InsertCodeUseCase
import com.s44khin.passman.codes.add.presentation.data.AddCodeArgsRamCache
import com.s44khin.passman.common.Constants
import com.s44khin.passman.core.ActionHandler
import com.s44khin.passman.core.StateStore
import com.s44khin.passman.core.StateStoreDelegate
import com.s44khin.passman.navigation.ScreenRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddCodeViewModel @Inject constructor(
    private val addCodeArgsRamCache: AddCodeArgsRamCache,
    private val insertCodeUseCase: InsertCodeUseCase,
    private val screenRouter: ScreenRouter,
) : ViewModel(), ActionHandler<AddCodeAction>, StateStore<AddCodeState> by StateStoreDelegate(
    initState = AddCodeState()
) {

    init {
        addCodeArgsRamCache.args?.let { args ->
            argsTaken(
                email = args.email,
                code = args.code,
                name = args.name,
                period = args.period,
            )
        }
    }

    override fun onAction(action: AddCodeAction) = when (action) {
        is AddCodeAction.BackClick -> screenRouter.back()
        is AddCodeAction.ChangeAccount -> viewState = viewState.toNewAccount(action.newAccount)
        is AddCodeAction.ChangeColor -> viewState = viewState.toNewColor(action.newColor)
        is AddCodeAction.ChangeDescription -> viewState = viewState.toNewDescription(action.newDescription)
        is AddCodeAction.ChangeName -> viewState = viewState.toNewName(action.newName)
        is AddCodeAction.ChangeSecretCode -> viewState = viewState.toNewSecretCode(action.newCode)
        is AddCodeAction.SaveClick -> saveClick()
        is AddCodeAction.ChangTimer -> viewState = viewState.toNewTimer(action.newTimer)
    }

    private fun saveClick() {
        viewModelScope.launch(Dispatchers.IO) {
            insertCodeUseCase.execute(
                secretCode = viewState.secretCode,
                name = viewState.name,
                color = viewState.color,
                account = viewState.account.ifEmpty { null },
                description = viewState.description.ifEmpty { null },
                timer = 30,
            )

            withContext(Dispatchers.Main) {
                screenRouter.backWithSignal(Constants.UPDATE_CODES_LIST)
            }
        }
    }

    private fun argsTaken(email: String, code: String, name: String, period: Int) {
        viewState = viewState
            .toNewAccount(email)
            .toNewSecretCode(code)
            .toNewName(name)
    }
}