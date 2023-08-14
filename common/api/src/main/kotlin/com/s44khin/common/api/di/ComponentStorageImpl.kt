package com.s44khin.common.api.di

import android.content.Context
import javax.inject.Inject

class ComponentStorageImpl @Inject constructor() : ComponentStorage {

    private val components: MutableMap<String, FeatureComponent> = mutableMapOf()

    fun initialize() {
        ComponentStorage.setInstance(this)
    }

    override fun <T : FeatureComponent> bind(
        context: Context,
        componentFactory: FeatureComponentFactory<T>
    ): T {
        val key = componentFactory.key

        return if (components.containsKey(key)) {
            components[key] as? T ?: throw IllegalArgumentException("В кеше не найден компонент")
        } else {
            componentFactory.create(context).also { components[key] = it }
        }
    }
}