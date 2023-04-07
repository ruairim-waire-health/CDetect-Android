package com.waire.cdetect.data.repository

import com.waire.cdetect.data.annotation.AppScope
import com.waire.cdetect.data.annotation.IODispatcher
import com.waire.cdetect.domain.repository.DeviceDataSource
import com.waire.cdetect.domain.repository.DeviceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class DeviceRepositoryImpl @Inject constructor(
    @AppScope private val appScope: CoroutineScope,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val dataSource: DeviceDataSource,
): DeviceRepository {

//    override suspend fun startDeviceScan(): CResult<Flow<Advertisement>> =
//        withContext(ioDispatcher) { dataSource.startScan() }
//
//    override suspend fun deviceConnect(deviceAddress: String): CResult<Peripheral> {
//        return withContext(ioDispatcher) { dataSource.connectToDevice(deviceAddress) }
//    }
}