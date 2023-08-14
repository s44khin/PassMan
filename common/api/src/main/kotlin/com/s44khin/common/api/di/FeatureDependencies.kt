package com.s44khin.common.api.di

interface FeatureDependencies

typealias FeatureDependenciesMap = Map<Class<out FeatureDependencies>, @JvmSuppressWildcards FeatureDependencies>

interface FeatureDependenciesProvider {
    val dependencies: FeatureDependenciesMap
}
