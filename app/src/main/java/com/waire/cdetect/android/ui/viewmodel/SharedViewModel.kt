package com.waire.cdetect.android.ui.viewmodel

import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.ui.state.DeviceConnectState
import com.waire.cdetect.android.ui.state.DeviceScanState
import com.waire.cdetect.domain.interactors.DeviceConnectInteractor
import com.waire.cdetect.domain.interactors.DeviceScanInteractor
import com.waire.cdetect.domain.model.CResult
import com.wairehealth.androiddevelopmentkit.Models.Devices.CDetectPayload
import com.wairehealth.androiddevelopmentkit.Utilites.Log
import com.wairehealth.androiddevelopmentkit.api.WaireConnectionLostException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
open class SharedViewModel @Inject constructor(
    private val deviceScan: DeviceScanInteractor,
    private val deviceConnect: DeviceConnectInteractor,
    application: Application,
) : AndroidViewModel(application) {

    lateinit var cDetect: UiDevice

    private val _uiScanState = MutableStateFlow<DeviceScanState>(DeviceScanState.Idle)
    val uiScanState: StateFlow<DeviceScanState> = _uiScanState

    private val _uiConnectState = MutableStateFlow<DeviceConnectState>(DeviceConnectState.Idle)
    val uiConnectState: StateFlow<DeviceConnectState> = _uiConnectState

    private val _cDetectPayload: MutableLiveData<CDetectPayload> = MutableLiveData()
    val cDetectPayload: MutableLiveData<CDetectPayload> = _cDetectPayload

    private var scanJob: Job? = null
    private var connectJob: Job? = null

    private val bluetoothAdapter: BluetoothAdapter by lazy {
        val bluetoothManager = application.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothManager.adapter
    }

    fun startScan() {
        _uiScanState.value = DeviceScanState.Loading
        scanJob?.cancel()

        scanJob = viewModelScope.launch {
            when (val result = deviceScan()) {
                is CResult.Success -> {
                    result.data.collect {
                        _uiScanState.value = DeviceScanState.Success(it)
                    }
                }
                is CResult.Error -> {
                    _uiScanState.value = result.error
                        .takeUnless { it is CancellationException }
                        ?.let(DeviceScanState::Error)
                        ?: DeviceScanState.Loading
                }
            }
        }
    }

    fun onDeviceSelected(device: UiDevice) {
        cDetect = device

        connectJob = viewModelScope.launch {
            when (val result = deviceConnect(device.address)) {
                is CResult.Success -> {
                    try {
                        val peripheral = result.data
                        _uiConnectState.value = DeviceConnectState.Success(peripheral)

                        peripheral.connect()
                        delay(3000)
                        peripheral.startSensor()

                        peripheral.observeData { }.collect { payload ->
                            _cDetectPayload.value = payload
                            android.util.Log.d("SharedViewModel: ", "onDeviceSelected: " + payload.toString())
                        }
                    } catch (ex: WaireConnectionLostException) {
                        Log.d("BLE Exception", ex.toString())
                    }
                }
                is CResult.Error ->
                    _uiConnectState.value = result.error
                        .takeUnless { it is CancellationException }
                        ?.let(DeviceConnectState::Error)
                        ?: DeviceConnectState.Loading
            }
        }
    }
}