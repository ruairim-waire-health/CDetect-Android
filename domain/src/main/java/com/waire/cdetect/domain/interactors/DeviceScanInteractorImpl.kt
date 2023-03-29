package com.waire.cdetect.domain.interactors

import com.waire.cdetect.domain.model.CResult
import com.waire.cdetect.domain.repository.DeviceRepository
import com.wairehealth.androiddevelopmentkit.api.Advertisement
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeviceScanInteractorImpl @Inject constructor(
    private val deviceRepository: DeviceRepository
): DeviceScanInteractor {
    override suspend fun invoke(): CResult<Flow<Advertisement>> = deviceRepository.startDeviceScan()
}