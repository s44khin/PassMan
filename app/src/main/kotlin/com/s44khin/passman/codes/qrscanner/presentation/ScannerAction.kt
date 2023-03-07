package com.s44khin.passman.codes.qrscanner.presentation

sealed class ScannerAction {

    data class OnQrGetting(val qr: String) : ScannerAction()
}
