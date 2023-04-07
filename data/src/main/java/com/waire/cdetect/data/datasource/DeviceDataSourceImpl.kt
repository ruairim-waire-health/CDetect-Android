package com.waire.cdetect.data.datasource

import com.waire.cdetect.domain.repository.DeviceDataSource
import javax.inject.Inject

class DeviceDataSourceImpl @Inject constructor() : DeviceDataSource {

//    private val bleController: BleController = WaireBleController()
//
//    override suspend fun startScan(): CResult<Flow<Advertisement>> =
//        runCatching { bleController.discoverDevices() }
//
//    override suspend fun connectToDevice(deviceAddress: String): CResult<Peripheral> {
//        return runCatching { bleController.createPeripheral(deviceAddress) }
//    }
}