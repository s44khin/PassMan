package com.s44khin.common.api.repositories

interface ContextRepository {

    fun copyToClipBoard(label: String, text: String)
}
