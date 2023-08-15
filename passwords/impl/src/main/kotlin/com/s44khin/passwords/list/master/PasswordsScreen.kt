package com.s44khin.passwords.list.master

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s44khin.common.api.di.injectViewModel
import com.s44khin.passwords.di.PasswordComponent
import com.s44khin.uikit.widgets.TopAppBarWithSearch
import com.s44khin.uikit.widgets.navigationBarsHeight

@Composable
fun PasswordsScreen() {
    val viewModel: PasswordsListViewModel = injectViewModel(PasswordComponent)

    var text by remember { mutableStateOf("") }

    val state = rememberLazyListState()

    val isScrolledToTop by remember {
        derivedStateOf { state.firstVisibleItemIndex == 0 && state.firstVisibleItemScrollOffset == 0 }
    }

    Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.surface)) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBarWithSearch(
                text = text,
                onInput = { text = it },
                onCloseClick = { text = "" },
                scrollState = state,
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = state,
                contentPadding = PaddingValues(bottom = navigationBarsHeight + 16.dp, top = 16.dp)
            ) {
                repeat(100) {
                    item {
                        PasswordItem {
                            viewModel.onDetailClick()
                        }
                    }
                }
            }
        }

        AnimatedVisibility(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = navigationBarsHeight + 16.dp, end = 16.dp),
            visible = isScrolledToTop,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut(),
        ) {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Default.Create, contentDescription = null)
            }
        }
    }
}

@Composable
private fun PasswordItem(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Text(text = "Hello World")
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "s44khin")
    }
}