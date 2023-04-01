package com.s44khin.passman.codes.qrscanner.presentation

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s44khin.passman.codes.navigation.CodesNavigation
import com.s44khin.passman.core.ActionHandler
import com.s44khin.passman.core.StateStore
import com.s44khin.passman.core.StateStoreDelegate
import com.s44khin.passman.navigation.ScreenRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScannerViewModel @Inject constructor(
    private val screenRouter: ScreenRouter,
) : ViewModel(), ActionHandler<ScannerAction>, StateStore<ScannerViewState> by StateStoreDelegate(
    initState = ScannerViewState()
) {

    override fun onAction(action: ScannerAction) = when (action) {
        is ScannerAction.OnQrGetting -> onQrGetting(action.qr)
    }

    private fun onQrGetting(qr: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val uri = Uri.parse(qr)
            val path = uri.path ?: return@launch
            val email = path.substring(1..path.lastIndex)

            val queryParameterNames = uri.queryParameterNames ?: return@launch

            if (queryParameterNames.isEmpty()) {
                return@launch
            }

            val secret = uri.getQueryParameter("secret") ?: return@launch
            val issuer = uri.getQueryParameter("issuer") ?: return@launch

            withContext(Dispatchers.Main) {
                screenRouter.navigateTo(
                    destination = CodesNavigation.Add(
                        email = email,
                        code = secret,
                        name = issuer,
                    ),
                    popUpTo = CodesNavigation.List
                )
            }
        }
    }
}