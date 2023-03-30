package com.waire.cdetect.android.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.waire.cdetect.android.models.UiDevice
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {

    lateinit var cDetect: UiDevice

    fun onDeviceSelected(device: UiDevice) {
        cDetect = device
        Log.d("SharedViewModel: ", "onDeviceSelected: ${device.name}")
        Log.d("SharedViewModel: ", "onDeviceSelected: ${device.address}")
        Log.d("SharedViewModel: ", "onDeviceSelected: ${device.address}")
    }
}