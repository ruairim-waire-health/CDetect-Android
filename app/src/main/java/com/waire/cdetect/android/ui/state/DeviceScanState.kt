package com.waire.cdetect.android.ui.state

sealed class DeviceScanState {
    object Idle : DeviceScanState()
    object Loading : DeviceScanState()
//    data class Success(val devices: Advertisement) : DeviceScanState()
    data class Error(val exception: Throwable) : DeviceScanState()

}