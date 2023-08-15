package com.s44khin.common.api.core

interface ActionHandler<ACTION> {

    fun onAction(action: ACTION)
}
