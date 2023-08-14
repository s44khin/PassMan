package com.s44khin.passman.di

import com.s44khin.common.api.di.FeatureDependencies
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class FeatureDependenciesKey(val value: KClass<out FeatureDependencies>)
