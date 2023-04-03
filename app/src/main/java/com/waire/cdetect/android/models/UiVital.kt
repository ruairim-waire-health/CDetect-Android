package com.waire.cdetect.android.models

import com.wairehealth.androiddevelopmentkit.Models.Enums.Activity
import com.wairehealth.androiddevelopmentkit.Models.Enums.HealthState
import com.wairehealth.androiddevelopmentkit.Models.Enums.ReadingQuality
import com.wairehealth.androiddevelopmentkit.Models.Enums.SkinContact
import com.wairehealth.androiddevelopmentkit.Models.Enums.SleepQuality
import com.wairehealth.androiddevelopmentkit.Models.Enums.UserMotion
import com.wairehealth.androiddevelopmentkit.Models.Enums.UserPosition
import com.wairehealth.androiddevelopmentkit.Models.Enums.VitalTrend

data class UiVital(
    val greenCounter: String,
    val greenCounter2: String,
    var irCounter: String,
    val redCounter: String,
    val accelX: String,
    val accelY: String,
    val accelZ: String,
    val batteryLevel: String,
    val heartRate: String,
    val heartRateConfidence: String,
    val rrInterval: String,
    var rrIntervalConfidence: String,
    val respirationRate: String,
    var respirationRateConfidence: String,
    val spO2: String,
    val spO2RValue: String,
    val spO2Confidence: String,
    val skinTemp: String,
    val coreBodyTemp: String,
    val coreBodyTemperatureConfidence: String,
    val activity: Activity = Activity.UNKNOWN,
    var skinContact: SkinContact = SkinContact.UNKNOWN,
    val userMotion: UserMotion = UserMotion.UNKNOWN,
    val userPosition: UserPosition = UserPosition.UNKNOWN,
    val lowSignalQuality: Boolean = false,
    val excessiveMotion: Boolean = false,
    val lowPI: Boolean = false,
    val unreliableR: Boolean = false,
    val loggingActive: Boolean = false,
    val healthState: HealthState = HealthState.UNKNOWN,
    val fallDetectReportId: Int = 0,
    val fallDetectFreefallPeriod: Int = 0,
    val fallDetectMaxmG: Short = 0,
    val fallDetectNoMotionPeriod: Int = 0,
    val perfusionIndexRed: Float = 0f,
    val perfusionIndexInfrared: Float = 0f,
    val restingHeartRate: String,
    val restingRespirationRate: String,
    val restingSpO2: String,
    val restingCoreBodyTemperature: String,
    val heartRateTrend: VitalTrend = VitalTrend.UNKNOWN,
    val respirationRateTrend: VitalTrend = VitalTrend.UNKNOWN,
    val spO2Trend: VitalTrend = VitalTrend.UNKNOWN,
    val coreBodyTemperatureTrend: VitalTrend = VitalTrend.UNKNOWN,
    val stressLevel: Int = 0,
    val dailyStepsRun: Int = 0,
    val dailyStepsWalk: Int = 0,
    val dailyKCalsExpended: Float = 0f,
    val dailyActiveKCalsExpended: Float = 0f,
    val sleepQuality: SleepQuality = SleepQuality.UNKNOWN,
    val beaconName: String = "",
    val beaconTemperature: Float = 0f,
    val beaconHumidity: Float = 0f,
    val beaconLightLevel: Float = 0f,
    val beaconNoiseLevel: Float = 0f,
    val heartRateVariability: Float = 0f,
    val heartRateVariabilityMotion: Boolean = false,
    val readingQuality: ReadingQuality = ReadingQuality.UNKNOWN,
    val isExtendedReport: Boolean = false,
)

