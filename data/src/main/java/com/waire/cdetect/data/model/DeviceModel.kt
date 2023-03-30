package com.waire.cdetect.data.model

data class DeviceModel(
    val skinContact: String,
    val heart: HeartRate,
    val respiratoryRate: RespiratoryRate,
    val temperature: Temperature,
    val pulseOximetry: PulseOximetry,
    val activity: Activity) {
    constructor() : this(
        skinContact = "Off",
        HeartRate(),
        RespiratoryRate(),
        Temperature(),
        PulseOximetry(),
        Activity()
    )
}
