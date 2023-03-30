package com.waire.cdetect.data.repository

import com.waire.cdetect.data.annotation.AppScope
import com.waire.cdetect.data.annotation.IODispatcher
import com.waire.cdetect.domain.model.CResult
import com.waire.cdetect.domain.repository.DeviceDataSource
import com.waire.cdetect.domain.repository.DeviceRepository
import com.wairehealth.androiddevelopmentkit.api.Advertisement
import com.wairehealth.androiddevelopmentkit.api.Peripheral
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeviceRepositoryImpl @Inject constructor(
    @AppScope private val appScope: CoroutineScope,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val dataSource: DeviceDataSource,
): DeviceRepository {

    override suspend fun startDeviceScan(): CResult<Flow<Advertisement>> =
        withContext(ioDispatcher) { dataSource.startScan() }

    override suspend fun deviceConnect(deviceAddress: String): Peripheral {
        return withContext(ioDispatcher) { dataSource.connectToDevice(deviceAddress) }
    }
}