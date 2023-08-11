package com.s44khin.passman.util

import androidx.compose.foundation.lazy.LazyListState

fun LazyListState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
