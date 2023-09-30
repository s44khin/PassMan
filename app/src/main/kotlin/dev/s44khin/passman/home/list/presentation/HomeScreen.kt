package dev.s44khin.passman.home.list.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.s44khin.passman.R
import dev.s44khin.passman.core.base.BaseScreen
import dev.s44khin.passman.core.navigation.navigate
import dev.s44khin.passman.home.list.presentation.widgets.HomeAccountItem
import dev.s44khin.passman.home.navigation.HomeNavigation
import dev.s44khin.uikit.widgets.AppTopNavBar
import dev.s44khin.uikit.widgets.Spacer
import dev.s44khin.uikit.widgets.bottomNavHeight

private enum class ContentType {
    Account
}

private val firstShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp, bottomStart = 4.dp, bottomEnd = 4.dp)
private val defaultShape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 4.dp, bottomEnd = 4.dp)
private val lastShape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 16.dp, bottomEnd = 16.dp)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() = BaseScreen(factory = { hiltViewModel<HomeViewModel>() }) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    onEffect = {
        when (it) {
            is HomeSideEffect.OpenDetail -> navController.navigate(HomeNavigation.Detail)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        AppTopNavBar(
            title = stringResource(R.string.app_name),
            scrollBehavior = scrollBehavior
        )

        LazyColumn(
            modifier = Modifier
                .navigationBarsPadding()
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(top = 16.dp, bottom = bottomNavHeight + 16.dp)
        ) {
            itemsIndexed(
                items = state.list,
                key = { _, item -> item.uid.uuid },
                contentType = { _, _ -> ContentType.Account }
            ) { index, account ->
                HomeAccountItem(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth(),
                    accountVO = account,
                    shape = when (index) {
                        0 -> firstShape
                        state.list.lastIndex -> lastShape
                        else -> defaultShape
                    },
                    onClick = { onAction(HomeAction.ItemClick(account.uid)) }
                )

                if (index != state.list.lastIndex) {
                    Spacer(height = 4.dp)
                }
            }
        }
    }
}
