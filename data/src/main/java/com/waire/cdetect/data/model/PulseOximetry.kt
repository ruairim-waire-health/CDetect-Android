package com.waire.cdetect.data.model

import com.wairehealth.androiddevelopmentkit.Models.Enums.VitalTrend

data class PulseOximetry(
    val spO2: String,
    val resting: String,
    val confidence: String,
    val trending: VitalTrend
) {
    constructor() : this(
        spO2 = "-",
        resting = "-",
        confidence = "-",
        trending = VitalTrend.UNKNOWN
    )
}
