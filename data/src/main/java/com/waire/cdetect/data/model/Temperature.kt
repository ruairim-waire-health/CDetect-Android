package com.waire.cdetect.data.model

import com.wairehealth.androiddevelopmentkit.Models.Enums.VitalTrend

data class Temperature(
    val current: String,
    val resting: String,
    val confidence: String,
    val trending: VitalTrend
) {
    constructor() : this(
        current = "-",
        resting = "-",
        confidence = "-",
        trending = VitalTrend.UNKNOWN
    )
}
