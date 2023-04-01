package com.s44khin.passman.codes.qrscanner.presentation

import android.Manifest
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.s44khin.passman.codes.qrscanner.presentation.widgets.CameraPreview
import com.s44khin.passman.core.BaseScreen
import com.s44khin.uikit.layouts.RootColumn

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ScannerScreen() = BaseScreen<ScannerViewState, ScannerAction, ScannerViewModel> {
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    RootColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
            Text(text = "add permission")
        }

        CameraPreview {
            onAction(ScannerAction.OnQrGetting(it))
        }
    }
}