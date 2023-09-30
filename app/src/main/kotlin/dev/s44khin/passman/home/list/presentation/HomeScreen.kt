package dev.s44khin.passman.home.list.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.s44khin.passman.R
import dev.s44khin.passman.core.base.BaseScreen
import dev.s44khin.passman.core.navigation.navigate
import dev.s44khin.passman.home.list.presentation.widgets.HomeScrollableContent
import dev.s44khin.passman.home.navigation.HomeNavigation
import dev.s44khin.uikit.widgets.AnimatedForeground
import dev.s44khin.uikit.widgets.AppTopNavBar
import dev.s44khin.uikit.widgets.AppTopNavBarAction
import dev.s44khin.uikit.widgets.FabSelector
import dev.s44khin.uikit.widgets.FabSelectorItem
import dev.s44khin.uikit.widgets.bottomNavHeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() = BaseScreen(factory = { hiltViewModel<HomeViewModel>() }) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    onEffect = {
        when (it) {
            is HomeSideEffect.OpenDetail -> navController.navigate(HomeNavigation.Detail)
        }
    }

    val scrollState = rememberLazyListState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            AppTopNavBar(
                title = stringResource(R.string.app_name),
                scrollBehavior = scrollBehavior,
                actions = listOf(
                    AppTopNavBarAction(
                        icon = Icons.Outlined.Search,
                        onClick = { onAction(HomeAction.SearchClick) }
                    )
                )
            )

            HomeScrollableContent(
                state = state,
                scrollState = scrollState,
                onAction = onAction,
            )
        }

        AnimatedForeground(
            visible = state.selectCreateVariantMode,
            onClick = { onAction(HomeAction.CreateSelectorExit) },
        )

        FabSelector(
            modifier = Modifier
                .navigationBarsPadding()
                .padding(bottom = bottomNavHeight + 16.dp, end = 16.dp)
                .align(Alignment.BottomEnd),
            inSelect = state.selectCreateVariantMode,
            visible = scrollState.canScrollForward,
            items = listOf(
                FabSelectorItem(
                    icon = Icons.Outlined.QrCode,
                    onClick = { }
                ),

                FabSelectorItem(
                    icon = Icons.Outlined.Create,
                    onClick = { }
                ),
            ),
            fab = FabSelectorItem(
                icon = Icons.Outlined.Add,
                onClick = { onAction(HomeAction.CreateClick) }
            ),
        )
    }
}
