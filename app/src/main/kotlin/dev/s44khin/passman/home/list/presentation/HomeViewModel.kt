package dev.s44khin.passman.home.list.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.passman.common.ContextRepository
import dev.s44khin.passman.core.base.BaseViewModel
import dev.s44khin.passman.core.coroutines.launchIoCoroutine
import dev.s44khin.passman.core.util.NativeText.Companion.toNativeText
import dev.s44khin.passman.home.list.domain.GetAccountsUseCase
import dev.s44khin.passman.home.list.presentation.model.AccountVO
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAccountsUseCase: GetAccountsUseCase,
    private val contextRepository: ContextRepository,
) : BaseViewModel<HomeState, HomeAction, HomeSideEffect>(
    initState = HomeState()
) {

    init {
        getAccounts()
    }

    override fun onAction(action: HomeAction) = when (action) {
        is HomeAction.ItemClick -> itemClick(action.account)
        is HomeAction.SearchClick -> searchClick()
        is HomeAction.CreateClick -> createClick()
        is HomeAction.CreateSelectorExit -> createSelectorExit()
        is HomeAction.ItemLongClick -> itemLongClick(action.account)
    }

    private fun itemClick(account: AccountVO) {
        viewModelScope.launchIoCoroutine {
            onEffect(HomeSideEffect.OpenDetail())
        }
    }

    private fun searchClick() {

    }

    private fun createClick() {
        viewState = viewState.copy(
            selectCreateVariantMode = !viewState.selectCreateVariantMode
        )
    }

    private fun createSelectorExit() {
        viewState = viewState.copy(
            selectCreateVariantMode = false
        )
    }

    private fun itemLongClick(account: AccountVO) {
        contextRepository.copyToClipboard(
            label = account.accountName,
            content = account.uid.toString().toNativeText(),
            isSensitiveContent = false,
        )
    }

    private fun getAccounts() {
        viewModelScope.launchIoCoroutine {
            viewState = viewState.copy(
                list = getAccountsUseCase.execute()
            )
        }
    }
}