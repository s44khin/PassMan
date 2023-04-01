package com.s44khin.passman.core

interface ActionHandler<ACTION : Any> {

    fun onAction(action: ACTION)
}
