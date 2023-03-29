package com.waire.cdetect.android.ui.start

import com.wairehealth.androiddevelopmentkit.api.Advertisement

sealed class DeviceScanState {
    data class Success(val devices: Advertisement): DeviceScanState()
    data class Error(val exception: Throwable): DeviceScanState()
    object Loading : DeviceScanState()
}
