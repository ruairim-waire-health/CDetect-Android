package com.waire.cdetect.android.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.waire.cdetect.android.mapper.UiMapper.toUiVital
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.models.UiVital
import com.waire.cdetect.android.ui.state.DeviceConnectState
import com.waire.cdetect.android.ui.state.DeviceScanState
import com.wairehealth.androiddevelopmentkit.BluetoothBoundService
import com.wairehealth.androiddevelopmentkit.Utilites.Log
import com.wairehealth.androiddevelopmentkit.api.WaireConnectionLostException
import com.wairehealth.androiddevelopmentkit.api.WaireData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class SharedViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application) {

    private lateinit var sdkBoundService: BluetoothBoundService

    private val _uiScanState = MutableStateFlow<DeviceScanState>(DeviceScanState.Idle)
    val uiScanState: StateFlow<DeviceScanState> = _uiScanState

    private val _uiConnectState = MutableStateFlow<DeviceConnectState>(DeviceConnectState.Idle)
    val uiConnectState: StateFlow<DeviceConnectState> = _uiConnectState

    private val _cDetectPayload: MutableLiveData<UiVital> = MutableLiveData()
    val cDetectPayload: MutableLiveData<UiVital> = _cDetectPayload

    fun setBoundService(waireSdkBoundService: BluetoothBoundService) {
        sdkBoundService = waireSdkBoundService
    }

    fun startScanFromBoundedService() {
        _uiScanState.value = DeviceScanState.Loading

        viewModelScope.launch {
            when (val flowResult = runCatching { sdkBoundService.startScanFromBoundService() }) {
                is UiResult.Success -> {
                    flowResult.data.collect {
                        _uiScanState.value = DeviceScanState.Success(it)
                    }
                }
                is UiResult.Error ->
                    _uiScanState.value = flowResult.error
                        .takeUnless { it is CancellationException }
                        ?.let(DeviceScanState::Error)
                        ?: DeviceScanState.Loading
            }
        }
    }

    fun onDeviceSelectedUsingBoundedService(device: UiDevice) {
        when (val result = runCatching {
            sdkBoundService.connectToDeviceFromBoundedService(device.address)
        }) {
            is UiResult.Success ->
                viewModelScope.launch {
                    try {
                        val peripheral = result.data
                        _uiConnectState.value = DeviceConnectState.Success(peripheral)
                        peripheral.connect()
                        delay(3000)
                        peripheral.observeData { }.collect { waireData ->
                            when (waireData) {
                                is WaireData.DevicePayload -> {
                                    _cDetectPayload.value = waireData.payload.toUiVital()

                                    android.util.Log.d(
                                        "SharedViewModel: ",
                                        "Heart rate: " + waireData.payload.heartRate.toString()
                                    )
                                    android.util.Log.d(
                                        "SharedViewModel: ",
                                        "Heart rate confidence: " + waireData.payload.heartRateConfidence.toString()
                                    )
                                    android.util.Log.d(
                                        "SharedViewModel: ",
                                        "batteryLevel: " + waireData.payload.batteryLevel.toString()
                                    )
                                    android.util.Log.d(
                                        "SharedViewModel: ",
                                        "coreBodyTemp00: " + waireData.payload.coreBodyTemp.toString()
                                    )
                                    android.util.Log.d(
                                        "SharedViewModel: ",
                                        "respiratory rate: " + waireData.payload.respirationRate.toString()
                                    )
                                    android.util.Log.d(
                                        "SharedViewModel: ",
                                        "respiratory confidence: " + waireData.payload.respirationRateConfidence.toString()
                                    )
                                    android.util.Log.d(
                                        "SharedViewModel: ",
                                        "Activity: " + waireData.payload.activity.toString()
                                    )
                                    android.util.Log.d(
                                        "SharedViewModel: ",
                                        "spO2: " + waireData.payload.spO2.toString()
                                    )
                                    android.util.Log.d(
                                        "SharedViewModel confidence: ",
                                        "spO2 confidencespO2Confidence " + waireData.payload.spO2Confidence.toString()
                                    )
                                }
                                is WaireData.WaireDeviceInfo -> {
                                    // Not impl'd yet
                                }
                                is WaireData.WaireSerial -> {
                                    // Not impl'd yet
                                }
                            }
                        }
                    } catch (ex: WaireConnectionLostException) {
                        Log.d("BLE Exception", ex.toString())
                    }
                }
            is UiResult.Error ->
                _uiConnectState.value = result.error
                    .takeUnless { it is CancellationException }
                    ?.let(DeviceConnectState::Error)
                    ?: DeviceConnectState.Loading
        }
    }
}