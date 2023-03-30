package com.waire.cdetect.android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.ui.state.DeviceConnectState
import com.waire.cdetect.android.ui.state.DeviceScanState
import com.waire.cdetect.domain.interactors.DeviceConnectInteractor
import com.waire.cdetect.domain.interactors.DeviceScanInteractor
import com.waire.cdetect.domain.model.CResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val deviceScan: DeviceScanInteractor,
    private val deviceConnect: DeviceConnectInteractor,
): ViewModel() {

    lateinit var cDetect: UiDevice

    private val _uiScanState = MutableStateFlow<DeviceScanState>(DeviceScanState.Idle)
    val uiScanState: StateFlow<DeviceScanState> = _uiScanState

    private val _uiConnectState = MutableStateFlow<DeviceConnectState>(DeviceConnectState.Idle)
    val uiConnectState: StateFlow<DeviceConnectState> = _uiConnectState

    private var scanJob: Job? = null
    private var connectJob: Job? = null

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
            when(val result = deviceConnect(device.address)) {
                is CResult.Success -> {
                    _uiConnectState.value = DeviceConnectState.Success(result.data)
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