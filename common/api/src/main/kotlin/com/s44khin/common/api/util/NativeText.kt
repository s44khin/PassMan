package com.s44khin.common.api.util

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.stringResource

@Immutable
sealed class NativeText {

    data class Simple(val value: String) : NativeText()

    data class Resource(@StringRes val resId: Int) : NativeText()

    fun resolve(context: Context) = when (this) {
        is Resource -> context.getString(this.resId)
        is Simple -> this.value
    }

    @Composable
    fun resolve() = when (this) {
        is Resource -> stringResource(this.resId)
        is Simple -> this.value
    }
}
