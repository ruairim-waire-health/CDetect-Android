package com.waire.cdetect.android.ui.state

import com.wairehealth.androiddevelopmentkit.api.Peripheral

sealed class DeviceConnectState {
    object Idle : DeviceConnectState()
    object Loading : DeviceConnectState()
    data class Success(val peripheral: Peripheral): DeviceConnectState()
    data class Error(val exception: Throwable): DeviceConnectState()

}