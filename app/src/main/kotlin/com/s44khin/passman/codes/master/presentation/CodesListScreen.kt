package com.s44khin.passman.codes.master.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.s44khin.passman.core.BaseScreen

@Composable
fun CodesListScreen() = BaseScreen<CodesListViewState, CodesListAction, CodesListViewModel> {
    Box(modifier = Modifier
        .fillMaxSize()
        .clickable { onAction(CodesListAction.TextClick) }) {
        Text(
            text = state.text, modifier = Modifier.align(Alignment.Center)
        )
    }
}