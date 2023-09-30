package dev.s44khin.passman.home.list.presentation.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import dev.s44khin.passman.core.util.NativeText
import dev.s44khin.passman.core.util.UID

@Immutable
data class AccountVO(
    val uid: UID = UID.randomUID(),
    val color: AccountColor = AccountColor.Pink,
    val accountName: NativeText,
    val email: NativeText,
)

enum class AccountColor(
    val value: Color,
) {
    Black(value = Color.Black),

    Green(value = Color.Green),

    Blue(value = Color.Blue),

    Yellow(value = Color.Yellow),

    Pink(value = Color(0xFFFFC0CB)),

    Red(value = Color.Red),

    Cyan(value = Color.Cyan),

    Violet(value = Color(0xFF7F00FF))
}
