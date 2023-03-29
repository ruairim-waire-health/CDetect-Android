package com.waire.cdetect.android.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waire.cdetect.domain.interactors.DeviceScanInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel@Inject constructor(
    private val deviceScan: DeviceScanInteractor
): ViewModel() {

    fun testHilt() {
        viewModelScope.launch {
            deviceScan.invoke()
        }
    }
}