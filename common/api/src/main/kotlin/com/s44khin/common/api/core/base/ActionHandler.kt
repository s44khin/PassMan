package com.s44khin.common.api.core.base

interface ActionHandler<ACTION> {

    fun onAction(action: ACTION)
}
