package com.waire.cdetect.domain.repository

import com.waire.cdetect.domain.model.CResult
import com.wairehealth.androiddevelopmentkit.api.Advertisement
import kotlinx.coroutines.flow.Flow

interface DeviceDataSource {
    suspend fun startScan(): CResult<Flow<Advertisement>>
}
