package com.s44khin.passman.codes.add.presentation.data

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

enum class CodeColor {

    Red, Green, Yellow, Blue, Orange, Brown, Pink, Purple;

    val color: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            Red -> Color(0xffb71c1c)
            Green -> Color(0xff1b5e20)
            Yellow -> Color(0xffffee58)
            Blue -> Color(0xff0d47a1)
            Orange -> Color(0xffef6c00)
            Brown -> Color(0xff5d4037)
            Pink -> Color(0xfff06292)
            Purple -> Color(0xff673ab7)
        }
}