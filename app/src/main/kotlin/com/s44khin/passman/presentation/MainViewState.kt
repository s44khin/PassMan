package com.s44khin.passman.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class MainViewState(
    val showBottomNavigation: Boolean = true
) {

    fun changeBottomNavigationVisibility() = copy(
        showBottomNavigation = !showBottomNavigation
    )
}
