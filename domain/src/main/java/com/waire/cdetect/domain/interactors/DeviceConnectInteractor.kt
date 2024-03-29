package com.waire.cdetect.domain.interactors

import com.waire.cdetect.domain.model.CResult
import com.wairehealth.androiddevelopmentkit.api.Peripheral
import kotlinx.coroutines.flow.Flow

interface DeviceConnectInteractor {
    suspend operator fun invoke(deviceAddress: String): CResult<Peripheral>
}