package com.s44khin.common.api.di

import android.content.Context

interface ComponentStorage {

    companion object : ComponentStorageCompanion()

    fun <T : FeatureComponent> bind(
        context: Context,
        componentFactory: FeatureComponentFactory<T>
    ): T
}
