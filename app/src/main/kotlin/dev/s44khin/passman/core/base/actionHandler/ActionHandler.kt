package dev.s44khin.passman.core.base.actionHandler

interface ActionHandler<ACTION> {

    fun onAction(action: ACTION)
}
