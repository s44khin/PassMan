package com.s44khin.passman.util

inline fun <T> List<T>.mapIf(predicate: (T) -> Boolean, transform: (T) -> T) = map { item ->
    if (predicate(item)) {
        transform(item)
    } else {
        item
    }
}

inline fun <T, R> List<T>.filterMap(predicate: (T) -> Boolean, transform: (T) -> R) = filter {
    predicate(it)
}.map {
    transform(it)
}