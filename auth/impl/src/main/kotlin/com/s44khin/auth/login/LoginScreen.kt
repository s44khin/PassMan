package com.s44khin.auth.login

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.s44khin.auth.di.AuthComponent
import com.s44khin.auth.login.widgets.NumPad
import com.s44khin.auth.login.widgets.Pin
import com.s44khin.common.api.di.injectViewModel

@Composable
internal fun LoginScreen() {
    val viewModel: LoginViewModel = AuthComponent.injectViewModel()
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .statusBarsPadding(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        AnimatedContent(
            modifier = Modifier
                .padding(top = 8.dp)
                .animateContentSize()
                .align(Alignment.CenterHorizontally),
            targetState = state.text,
            label = "animatedText",
            transitionSpec = {
                slideInVertically { it } + scaleIn() togetherWith slideOutVertically { -it } + scaleOut()
            }
        ) {
            Text(
                text = it.resolve(),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Pin(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            viewState = state,
            onAction = viewModel::onAction
        )

        NumPad(
            onAction = viewModel::onAction
        )
    }
}
