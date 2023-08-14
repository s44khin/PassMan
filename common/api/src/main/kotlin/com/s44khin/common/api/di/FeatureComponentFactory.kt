package com.s44khin.common.api.di

import android.content.Context

interface FeatureComponentFactory<out T : FeatureComponent> {

    fun create(context: Context): T

    val key: String get() = javaClass.toString()
}
