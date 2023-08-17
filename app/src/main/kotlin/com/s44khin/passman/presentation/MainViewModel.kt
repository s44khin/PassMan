package com.s44khin.passman.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s44khin.common.api.core.base.StateStore
import com.s44khin.common.api.core.base.StateStoreImpl
import com.s44khin.common.api.navigation.ScreenRouter
import com.s44khin.passman.presentation.data.BottomNavigationVisibilityDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val bottomNavigationVisibilityDispatcher: BottomNavigationVisibilityDispatcher,
    private val screenRouter: ScreenRouter,
) : ViewModel(), StateStore<MainViewState> by StateStoreImpl(
    initState = MainViewState()
) {

    init {
        collectBottomNavigationVisibility()
    }

    private fun collectBottomNavigationVisibility() {
        viewModelScope.launch(Dispatchers.IO) {
            bottomNavigationVisibilityDispatcher.collectBottomNavigationVisibility {
                if (it != viewState.showBottomNavigation) {
                    viewState = viewState.changeBottomNavigationVisibility()
                }
            }
        }
    }
}