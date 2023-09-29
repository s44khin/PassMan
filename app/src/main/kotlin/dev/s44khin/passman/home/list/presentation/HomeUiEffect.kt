package dev.s44khin.passman.home.list.presentation

import dev.s44khin.passman.core.base.UiEffect

sealed class HomeUiEffect : UiEffect() {

    class OpenDetail : HomeUiEffect()
}
