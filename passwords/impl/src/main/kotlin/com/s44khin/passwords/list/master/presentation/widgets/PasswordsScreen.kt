package com.s44khin.passwords.list.master.presentation.widgets

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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.s44khin.common.api.core.base.screen.ScreenScope
import com.s44khin.common.api.util.CommonStrings
import com.s44khin.passwords.list.master.presentation.PasswordsListAction
import com.s44khin.passwords.list.master.presentation.PasswordsListViewState
import com.s44khin.uikit.widgets.navigationBarsHeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ScreenScope<PasswordsListViewState, PasswordsListAction>.PasswordsListContent() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val scrollState = rememberLazyListState()

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(CommonStrings.app_name)) },
                scrollBehavior = scrollBehavior,
                actions = {
                    IconButton(
                        onClick = { onAction(PasswordsListAction.SearchClick) },
                        content = { Icon(imageVector = Icons.Default.Search, contentDescription = Icons.Default.Search.name) }
                    )
                }
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = scrollState,
                contentPadding = PaddingValues(bottom = navigationBarsHeight + 16.dp + 56.dp)
            ) {
                repeat(100) {
                    item {
                        PasswordItem { onAction(PasswordsListAction.OnItemClick) }
                    }
                }
            }
        }

        FloatingActionButton(
            modifier = Modifier
                .padding(bottom = navigationBarsHeight + 16.dp, end = 16.dp)
                .align(Alignment.BottomEnd),
            content = { Icon(imageVector = Icons.Default.Add, contentDescription = Icons.Default.Add.name) },
            onClick = { onAction(PasswordsListAction.OnAddClick) }
        )
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