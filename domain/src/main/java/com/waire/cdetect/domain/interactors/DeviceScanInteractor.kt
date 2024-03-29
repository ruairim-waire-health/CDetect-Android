package com.waire.cdetect.domain.interactors

import com.waire.cdetect.domain.model.CResult
import com.wairehealth.androiddevelopmentkit.api.Advertisement
import kotlinx.coroutines.flow.Flow

interface DeviceScanInteractor {
    suspend operator fun invoke(): CResult<Flow<Advertisement>>
}