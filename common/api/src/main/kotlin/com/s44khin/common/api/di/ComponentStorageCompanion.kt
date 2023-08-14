package com.s44khin.common.api.di

import android.content.Context

open class ComponentStorageCompanion : ComponentStorage {

    private var instance: ComponentStorage? = null

    fun setInstance(instance: ComponentStorage) {
        this.instance = instance
    }

    override fun <T : FeatureComponent> bind(
        context: Context,
        componentFactory: FeatureComponentFactory<T>
    ): T {
        return instance
            ?.bind(context, componentFactory)
            ?: throw IllegalStateException("ComponentStorage не инициализирован")
    }
}