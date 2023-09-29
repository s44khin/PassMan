package dev.s44khin.passman.home.list.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.passman.core.base.BaseViewModel
import dev.s44khin.passman.core.coroutines.launchIoCoroutine
import dev.s44khin.passman.core.util.UID
import dev.s44khin.passman.home.list.domain.GetAccountsUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAccountsUseCase: GetAccountsUseCase,
) : BaseViewModel<HomeState, HomeAction, HomeUiEffect>(
    initState = HomeState()
) {

    init {
        getAccounts()
    }

    override fun onAction(action: HomeAction) = when (action) {
        is HomeAction.ItemClick -> itemClick(action.uid)
    }

    private fun itemClick(uid: UID) {
        viewModelScope.launchIoCoroutine {
            onEffect(HomeUiEffect.OpenDetail())
        }
    }

    private fun getAccounts() {
        viewModelScope.launchIoCoroutine {
            viewState = viewState.copy(
                list = getAccountsUseCase.execute()
            )
        }
    }
}