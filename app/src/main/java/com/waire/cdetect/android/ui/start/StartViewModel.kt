package com.waire.cdetect.android.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class StartViewModel @Inject constructor(
    private val deviceScan: DeviceScanInteractor
) : ViewModel() {

    private val _uiState = MutableStateFlow<DeviceScanState>(DeviceScanState.Idle)
    val uiState: StateFlow<DeviceScanState> = _uiState

    private var scanJob: Job? = null

    internal fun startScan() {
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
}