package com.s44khin.common.api.core.base.screen

interface ScreenScope<STATE : Any, ACTION> {

    val viewState: STATE
    val onAction: (ACTION) -> Unit
}