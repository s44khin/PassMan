package com.s44khin.common.api.di

import android.content.Context

/**
 * Берет зависимости типа [T] из провайдера.
 */
inline fun <reified T : FeatureDependencies> Context.findFeatureDependencies(): T {
    return findFeatureDependenciesProvider()[T::class.java]?.let {
        it as T
    } ?: error("Не найдена зависимость ${T::class.qualifiedName} для $this")
}

/**
 * Ищет ближайший провайдер зависимостей для компонента.
 */
fun Context.findFeatureDependenciesProvider(): FeatureDependenciesMap {
    val componentDependencies = when (applicationContext) {
        is FeatureDependenciesProvider -> applicationContext as FeatureDependenciesProvider
        else -> error("Не найден провайдер зависимостей для $this")
    }

    return componentDependencies.dependencies
}
