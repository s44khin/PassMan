package com.s44khin.uikit.theme

import androidx.compose.ui.graphics.Color

enum class PrimaryColor(
    val primary: Color,
    val onPrimary: Color,
) {

    BROWN(
        primary = Color(0xff531600),
        onPrimary = Color.White,
    ),

    BROWN2(
        primary = Color(0xfffbc19f),
        onPrimary = Color.Black,
    ),

    PINK(
        primary = Color(0xffee6464),
        onPrimary = Color.White,
    ),

    ORANGE(
        primary = Color(0xffe65100),
        onPrimary = Color.White,
    ),

    YELLOW(
        primary = Color(0xfff9ea2e),
        onPrimary = Color.Black,
    ),

    GREEN(
        primary = Color(0xff71c860),
        onPrimary = Color.Black,
    ),

    GREEN2(
        primary = Color(0xff005b00),
        onPrimary = Color.White,
    ),

    BLUE(
        primary = Color(0xff2e7ef9),
        onPrimary = Color.White,
    ),

    BLUE2(
        primary = Color(0xff113cab),
        onPrimary = Color.White,
    ),

    PURPLE(
        primary = Color(0xff9c00f0),
        onPrimary = Color.White,
    )
}