package com.waire.cdetect.android.mapper

import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.models.UiVital
import com.wairehealth.androiddevelopmentkit.Models.Devices.CDetectPayload
import com.wairehealth.androiddevelopmentkit.api.Advertisement

object UiMapper {
    fun Advertisement.toUiDevice() = UiDevice(
        name = name ?: "Unknown",
        rssi = rssi,
        address = address
    )

    fun CDetectPayload.toUiVital() = UiVital(
        greenCounter = greenCounter.toString(),
        greenCounter2 = greenCounter2.toString(),
        irCounter = irCounter.toString(),
        redCounter = redCounter.toString(),
        accelX = accelX.toString(),
        accelY = accelY.toString(),
        accelZ = accelZ.toString(),
        batteryLevel = batteryLevel.toString(),
        heartRate = heartRate.toString(),
        heartRateConfidence = heartRateConfidence.toString(),
        rrInterval = rrInterval.toString(),
        rrIntervalConfidence = rrIntervalConfidence.toString(),
        respirationRate = respirationRate.toString(),
        respirationRateConfidence = respirationRateConfidence.toString(),
        spO2 = spO2.toString(),
        spO2RValue = spO2RValue.toString(),
        spO2Confidence = spO2Confidence.toString(),
        skinTemp = skinTemp.toString(),
        coreBodyTemp = coreBodyTemp.toString(),
        coreBodyTemperatureConfidence =coreBodyTemperatureConfidence.toString(),
        activity = activity,
        skinContact = skinContact,
        userMotion = userMotion,
        userPosition = userPosition,
        lowSignalQuality = lowSignalQuality,
        excessiveMotion =excessiveMotion,
        lowPI = lowPI,
        unreliableR = unreliableR,
        loggingActive = loggingActive,
        healthState = healthState,
        fallDetectReportId = fallDetectReportId,
        fallDetectFreefallPeriod = fallDetectFreefallPeriod,
        fallDetectMaxmG = fallDetectMaxmG,
        fallDetectNoMotionPeriod = fallDetectNoMotionPeriod,
        perfusionIndexRed = perfusionIndexRed,
        perfusionIndexInfrared = perfusionIndexInfrared,
        restingHeartRate = restingHeartRate.toString(),
        restingRespirationRate = restingRespirationRate.toString(),
        restingSpO2 = restingSpO2.toString(),
        restingCoreBodyTemperature = restingCoreBodyTemperature.toString(),
        heartRateTrend = heartRateTrend,
        respirationRateTrend = respirationRateTrend,
        spO2Trend = spO2Trend,
        coreBodyTemperatureTrend = coreBodyTemperatureTrend,
        stressLevel = stressLevel,
        dailyStepsRun = dailyStepsRun,
        dailyStepsWalk = dailyStepsWalk,
        dailyKCalsExpended = dailyKCalsExpended,
        dailyActiveKCalsExpended = dailyActiveKCalsExpended,
        sleepQuality = sleepQuality,
        beaconName = beaconName,
        beaconTemperature = beaconTemperature,
        beaconHumidity = beaconHumidity,
        beaconLightLevel = beaconLightLevel,
        beaconNoiseLevel = beaconNoiseLevel,
        heartRateVariability = heartRateVariability,
        heartRateVariabilityMotion = heartRateVariabilityMotion,
        readingQuality = readingQuality,
        isExtendedReport = isExtendedReport
    )
}