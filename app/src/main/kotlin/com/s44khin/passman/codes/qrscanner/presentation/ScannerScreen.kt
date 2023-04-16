package com.s44khin.passman.codes.qrscanner.presentation

import android.Manifest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.s44khin.passman.R
import com.s44khin.passman.codes.qrscanner.presentation.widgets.CameraPreview
import com.s44khin.passman.core.BaseScreen
import com.s44khin.uikit.theme.AppTheme
import com.s44khin.uikit.widgets.AppButtonSmall
import com.s44khin.uikit.widgets.TopNav
import com.s44khin.uikit.widgets.TopNavIcon

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ScannerScreen() = BaseScreen<ScannerViewState, ScannerAction, ScannerViewModel> {
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA) { result ->
    }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topNav, warning, scanner, permissionMessage, permissionButton) = createRefs()

        TopNav(
            modifier = Modifier.constrainAs(topNav) {
                top.linkTo(parent.top)
            },
            label = stringResource(R.string.scanner_label),
            navIcon = TopNavIcon(
                icon = Icons.Rounded.ArrowBack,
                onClick = { onAction(ScannerAction.BackClick) }
            )
        )

        if (cameraPermissionState.status.isGranted) {
            Text(
                modifier = Modifier.constrainAs(warning) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(topNav.bottom)
                    bottom.linkTo(scanner.top)
                },
                text = stringResource(R.string.scanner_warning),
                fontSize = 18.sp,
                color = AppTheme.colors.textOnBackgroundVariant,
                textAlign = TextAlign.Center,
            )
        } else {
            Text(
                modifier = Modifier.constrainAs(permissionMessage) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(topNav.bottom)
                    bottom.linkTo(permissionButton.top)
                },
                text = stringResource(R.string.scanner_permission),
                fontSize = 18.sp,
                color = AppTheme.colors.textOnBackgroundVariant,
                textAlign = TextAlign.Center,
            )

            AppButtonSmall(
                modifier = Modifier.constrainAs(permissionButton) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(permissionMessage.bottom)
                    bottom.linkTo(scanner.top)
                },
                label = stringResource(R.string.scanner_permission_button),
                onClick = { cameraPermissionState.launchPermissionRequest() }
            )
        }

        Box(
            modifier = Modifier.constrainAs(scanner) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            CameraPreview {
                onAction(ScannerAction.OnQrGetting(it))
            }
        }
    }
}