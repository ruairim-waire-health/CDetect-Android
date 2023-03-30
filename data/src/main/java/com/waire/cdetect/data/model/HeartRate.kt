package com.waire.cdetect.data.model

import com.wairehealth.androiddevelopmentkit.Models.Enums.VitalTrend

data class HeartRate(
    val current: String,
    val resting: String,
    val confidence: String,
    val trending: VitalTrend,
    val perfusionIndexInfrared: String,
    val perfusionIndexRed: String
) {
    constructor() : this(
        current= "-",
        resting = "-",
        confidence = "-",
        trending = VitalTrend.UNKNOWN,
        perfusionIndexInfrared = "-",
        perfusionIndexRed = "-"
    )
}
