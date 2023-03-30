package com.waire.cdetect.data.datasource

import com.waire.cdetect.domain.model.CResult
import com.waire.cdetect.domain.model.runCatching
import com.waire.cdetect.domain.repository.DeviceDataSource
import com.wairehealth.androiddevelopmentkit.Services.WaireBleController
import com.wairehealth.androiddevelopmentkit.api.Advertisement
import com.wairehealth.androiddevelopmentkit.api.BleController
import com.wairehealth.androiddevelopmentkit.api.Peripheral
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeviceDataSourceImpl @Inject constructor() : DeviceDataSource {

    private val bleController: BleController = WaireBleController()

    override suspend fun startScan(): CResult<Flow<Advertisement>> =
        runCatching { bleController.discoverDevices() }

    override suspend fun connectToDevice(deviceAddress: String): Peripheral {
        return bleController.createPeripheral(deviceAddress)
    }

    companion object {
        const val SCAN_DURATION_MILLIS = 5000
    }
}