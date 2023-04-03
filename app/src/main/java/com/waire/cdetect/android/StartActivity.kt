package com.waire.cdetect.android

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.waire.cdetect.android.permissions.PermissionsHandler
import com.waire.cdetect.android.ui.theme.CDetectAndroidTheme
import com.waire.cdetect.android.ui.viewmodel.SharedViewModel
import com.wairehealth.androiddevelopmentkit.BluetoothBoundService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : ComponentActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    var waireSdkBoundService: BluetoothBoundService? = null
    var isBound: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindService()
//        setContent {
//            if (waireSdkBoundService != null) {
//                CDetectAndroidTheme {
//                    PermissionsHandler(sharedViewModel)
//                }
//            } else {
//                Log.d(javaClass.simpleName, "onCreate: Cannot proceed until Bound service has been started")
//            }
//        }
    }

    /**
     * Used to bind to our service class
     */
    private fun bindService() {
        Intent(this, BluetoothBoundService::class.java).also { intent ->
            bindService(intent, myBleServiceConnection, Context.BIND_AUTO_CREATE)
        }
    }

    /**
     * Used to unbind and stop our service class
     */
    private fun unbindService() {
        Intent(this, BluetoothBoundService::class.java).also { intent ->
            unbindService(myBleServiceConnection)
        }
    }

    private val myBleServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName?, service: IBinder?) {
            Log.d(javaClass.simpleName, "ServiceConnection: connected to service.")
            val binder = service as BluetoothBoundService.CDetectBinder
            waireSdkBoundService = binder.getService()
            isBound = true
            sharedViewModel.setBoundService(waireSdkBoundService!!)

            setContent {
                CDetectAndroidTheme {
                    PermissionsHandler(sharedViewModel)
                }
            }
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            Log.d(javaClass.simpleName, "ServiceConnection: disconnected from service.")
            isBound = false
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CDetectAndroidTheme {

    }
}