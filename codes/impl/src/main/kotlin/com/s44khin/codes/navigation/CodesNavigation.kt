package com.s44khin.codes.navigation

import androidx.navigation.NavGraphBuilder
import com.s44khin.codes.CodesScreen
import com.s44khin.codes.api.navigation.CodesNavigation
import com.s44khin.common.api.navigation.navigation
import com.s44khin.common.api.navigation.rootComposable

fun NavGraphBuilder.codesNavigation() {
    navigation(
        rootDestination = CodesNavigation,
        startDestination = CodesNavigation.List
    ) {
        rootComposable(destination = CodesNavigation.List) {
            CodesScreen()
        }
    }
}