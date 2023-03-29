package com.waire.cdetect.data.mapper

import com.waire.cdetect.domain.model.CDetectAdvertisement
import com.wairehealth.androiddevelopmentkit.api.Advertisement

object SdkModelMapper {
    fun Advertisement.toDomainAdvertisement() = CDetectAdvertisement(
        name = name,
        rssi = rssi,
        address = address
    )
}