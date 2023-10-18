package dev.s44khin.passman.core.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.s44khin.passman.core.base.actionHandler.ActionHandler
import dev.s44khin.passman.core.navigation.ScreenRouter
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val screenRouter: ScreenRouter,
) : ViewModel(), ActionHandler<MainAction> {

    override fun onAction(action: MainAction) {
        TODO("Not yet implemented")
    }
}
