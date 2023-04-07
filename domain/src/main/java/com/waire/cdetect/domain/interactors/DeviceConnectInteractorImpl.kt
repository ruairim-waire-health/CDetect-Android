package com.waire.cdetect.domain.interactors

import com.waire.cdetect.domain.repository.DeviceRepository
import javax.inject.Inject

class DeviceConnectInteractorImpl @Inject constructor(
    private val deviceRepository: DeviceRepository
) : DeviceConnectInteractor {
//    override suspend fun invoke(deviceAddress: String): CResult<Peripheral> =
//        deviceRepository.deviceConnect(deviceAddress)
}