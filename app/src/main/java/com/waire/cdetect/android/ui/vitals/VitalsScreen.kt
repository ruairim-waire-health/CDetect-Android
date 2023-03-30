package com.waire.cdetect.android.ui.vitals

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.waire.cdetect.android.ui.SharedViewModel

@Composable
fun VitalsScreen(modifier: Modifier, viewModel: SharedViewModel, navController: NavHostController) {

    val device = viewModel.cDetect

    LaunchedEffect(key1 = device) {
        Log.d("VitalsScreen: ", "device: ${device.name}")
        Log.d("VitalsScreen: ", "device: ${device.address}")
        Log.d("VitalsScreen: ", "device: ${device.address}")
    }
}