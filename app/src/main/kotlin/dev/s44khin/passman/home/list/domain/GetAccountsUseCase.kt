package dev.s44khin.passman.home.list.domain

import dev.s44khin.passman.core.util.NativeText.Companion.toNativeText
import dev.s44khin.passman.home.list.presentation.model.AccountColor
import dev.s44khin.passman.home.list.presentation.model.AccountVO
import javax.inject.Inject

class GetAccountsUseCase @Inject constructor() {

    suspend fun execute() = listOfAccMock
}

val listOfAccMock = listOf(
    AccountVO(
        color = AccountColor.Cyan,
        accountName = "Google".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Red,
        accountName = "Yandex".toNativeText(),
        email = "s4nokhin@yandex.ru".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Blue,
        accountName = "Ozon".toNativeText(),
        email = "aleksanokhin@ozon.ru".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Violet,
        accountName = "Twitch".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Yellow,
        accountName = "Taxi".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Black,
        accountName = "Apple".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Pink,
        accountName = "Telegram".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Cyan,
        accountName = "Google".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Red,
        accountName = "Yandex".toNativeText(),
        email = "s4nokhin@yandex.ru".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Blue,
        accountName = "Ozon".toNativeText(),
        email = "aleksanokhin@ozon.ru".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Violet,
        accountName = "Twitch".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Yellow,
        accountName = "Taxi".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Black,
        accountName = "Apple".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),

    AccountVO(
        color = AccountColor.Pink,
        accountName = "Telegram".toNativeText(),
        email = "s44khin@gmail.com".toNativeText()
    ),
)