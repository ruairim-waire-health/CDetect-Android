package com.waire.cdetect.android.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.ui.start.DeviceScanState
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
    private val deviceScan: DeviceScanInteractor
): ViewModel() {

    lateinit var cDetect: UiDevice

    private val _uiState = MutableStateFlow<DeviceScanState>(DeviceScanState.Idle)
    val uiState: StateFlow<DeviceScanState> = _uiState

    private var scanJob: Job? = null

    fun startScan() {
        _uiState.value = DeviceScanState.Loading
        scanJob?.cancel()

        scanJob = viewModelScope.launch {
            when (val result = deviceScan()) {
                is CResult.Success -> {
                    result.data.collect {
                        _uiState.value = DeviceScanState.Success(it)
                    }
                }
                is CResult.Error -> {
                    _uiState.value = result.error
                        .takeUnless { it is CancellationException }
                        ?.let(DeviceScanState::Error)
                        ?: DeviceScanState.Loading
                }
            }
        }
    }

    fun onDeviceSelected(device: UiDevice) {
        cDetect = device
        Log.d("SharedViewModel: ", "onDeviceSelected: ${device.name}")
        Log.d("SharedViewModel: ", "onDeviceSelected: ${device.address}")
        Log.d("SharedViewModel: ", "onDeviceSelected: ${device.address}")
    }
}