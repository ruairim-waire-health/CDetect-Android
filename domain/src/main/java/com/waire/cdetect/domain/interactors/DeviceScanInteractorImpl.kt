package com.waire.cdetect.domain.interactors

import com.waire.cdetect.domain.repository.DeviceRepository
import javax.inject.Inject

class DeviceScanInteractorImpl @Inject constructor(
    private val deviceRepository: DeviceRepository
): DeviceScanInteractor {
//    override suspend fun invoke(): CResult<Flow<Advertisement>> = deviceRepository.startDeviceScan()
}