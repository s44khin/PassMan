package com.s44khin.passman.codes.qrscanner.presentation

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.s44khin.passman.R
import com.s44khin.passman.codes.qrscanner.presentation.widgets.CameraPreview
import com.s44khin.passman.core.BaseScreen
import com.s44khin.uikit.widgets.Spacer
import com.s44khin.uikit.widgets.TopNav
import com.s44khin.uikit.widgets.TopNavIcon

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ScannerScreen() = BaseScreen<ScannerViewState, ScannerAction, ScannerViewModel> {
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        TopNav(
            label = stringResource(R.string.scanner_label),
            navIcon = TopNavIcon(
                icon = Icons.Rounded.ArrowBack,
                onClick = { onAction(ScannerAction.BackClick) }
            )
        )

        Spacer(height = 8.dp)

        Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
            Text(text = "add permission")
        }

        CameraPreview {
            onAction(ScannerAction.OnQrGetting(it))
        }
    }
}