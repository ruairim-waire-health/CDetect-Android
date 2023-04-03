package com.waire.cdetect.domain.interactors

import com.waire.cdetect.domain.model.CResult
import com.waire.cdetect.domain.repository.DeviceRepository
import com.wairehealth.androiddevelopmentkit.api.Peripheral
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeviceConnectInteractorImpl @Inject constructor(
    private val deviceRepository: DeviceRepository
) : DeviceConnectInteractor {
    override suspend fun invoke(deviceAddress: String): CResult<Peripheral> =
        deviceRepository.deviceConnect(deviceAddress)
}