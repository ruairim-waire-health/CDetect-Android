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
import com.wairehealth.androiddevelopmentkit.Callbacks.Device.WaireDeviceDelegate
import com.wairehealth.androiddevelopmentkit.Callbacks.Manager.WaireBluetoothManagerDelegate
import com.wairehealth.androiddevelopmentkit.Models.Devices.CDetectPayload
import com.wairehealth.androiddevelopmentkit.Models.Devices.CDetectPeripheral
import com.wairehealth.androiddevelopmentkit.Models.Devices.DiscoveredDevice
import com.wairehealth.androiddevelopmentkit.Models.Enums.DeviceState
import com.wairehealth.androiddevelopmentkit.Services.WaireBluetoothService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : ComponentActivity(), WaireBluetoothManagerDelegate, WaireDeviceDelegate {

    private val sharedViewModel: SharedViewModel by viewModels()

    var waireSdkService: WaireBluetoothService? = null
    var isBound: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindService()
    }

    /**
     * Used to bind to our service class
     */
    private fun bindService() {
        Intent(this, WaireBluetoothService::class.java).also { intent ->
            bindService(intent, myBleServiceConnection, Context.BIND_AUTO_CREATE)
        }
    }

    /**
     * Used to unbind and stop our service class
     */
    private fun unbindService() {
        Intent(this, WaireBluetoothService::class.java).also { intent ->
            unbindService(myBleServiceConnection)
        }
    }

    private val myBleServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName?, service: IBinder?) {
            Log.d(javaClass.simpleName, "ServiceConnection: connected to service.")
            val binder = service as WaireBluetoothService.LocalBinder
            waireSdkService = binder.getServerInstance()
            isBound = true
            sharedViewModel.setBoundService(waireSdkService!!)

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

    override fun deviceStateDidChange(device: CDetectPeripheral, state: DeviceState) {
        TODO("Not yet implemented")
    }

    override fun readingsDidChange(device: CDetectPeripheral, readings: CDetectPayload) {
        TODO("Not yet implemented")
    }

    override fun onDeviceConnected(device: CDetectPeripheral) {
        TODO("Not yet implemented")
    }

    override fun onDeviceDisconnected(device: CDetectPeripheral) {
        TODO("Not yet implemented")
    }

    override fun onDeviceDiscovered(device: DiscoveredDevice) {
        TODO("Not yet implemented")
    }

    override fun onDeviceFailedToConnect(device: CDetectPeripheral, reason: String) {
        TODO("Not yet implemented")
    }

    override fun onFinishedScanning() {
        TODO("Not yet implemented")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CDetectAndroidTheme {

    }
}