package com.waire.cdetect.android.permissions

import android.Manifest
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.waire.cdetect.android.ui.CDetectScaffold

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionsHandler() {

    val permissionState =
        rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                permissionState.launchPermissionRequest()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    })

    when {
        permissionState.hasPermission -> {
            CDetectScaffold(modifier = Modifier.fillMaxSize())
        }
        permissionState.shouldShowRationale -> {
            Column {
                Toast.makeText(
                    LocalContext.current,
                    "Reading location permission is required by this app",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        !permissionState.hasPermission && !permissionState.shouldShowRationale -> {
            Toast.makeText(
                LocalContext.current,
                "You need to enable location permission in order to use this application",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}


