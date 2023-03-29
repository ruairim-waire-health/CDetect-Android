package com.waire.cdetect.android.mapper

import com.waire.cdetect.android.models.UiDevice
import com.wairehealth.androiddevelopmentkit.api.Advertisement

object UiMapper {
    fun Advertisement.toUiDevice() = UiDevice(
        name = name ?: "Unknown",
        rssi = rssi,
        address = address
    )
}