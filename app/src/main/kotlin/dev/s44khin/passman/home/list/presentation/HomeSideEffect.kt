package dev.s44khin.passman.home.list.presentation

import dev.s44khin.passman.core.base.AppSideEffect

sealed class HomeSideEffect : AppSideEffect() {

    class OpenDetail : HomeSideEffect()
}
