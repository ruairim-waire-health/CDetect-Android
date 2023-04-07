package com.waire.cdetect.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BatteryFull
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.waire.cdetect.android.R
import com.waire.cdetect.android.ui.composables.LoadingCard
import com.waire.cdetect.android.ui.composables.VitalView
import com.waire.cdetect.android.ui.state.DeviceConnectState
import com.waire.cdetect.android.ui.theme.grid_4
import com.waire.cdetect.android.ui.theme.grid_6
import com.waire.cdetect.android.ui.theme.grid_8
import com.waire.cdetect.android.ui.viewmodel.SharedViewModel

@Composable
fun VitalsScreen(
    modifier: Modifier,
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {
    val connectState = sharedViewModel.uiConnectState.collectAsState().value
    val payload by sharedViewModel.cDetectPayload.collectAsState()
    val isDeviceConnected = remember { mutableStateOf(false) }

    Column() {
//        ConnectionTopBar(isConnected = isDeviceConnected.value)
        Column(
            modifier = modifier.padding(vertical = grid_8, horizontal = grid_6),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = grid_4)
                    .padding(grid_8),
            )
            Button(onClick = {
//                sharedViewModel.makeAnotherReq()

            }) {
                Text(text = "make another request")
            }
            when (connectState) {
                is DeviceConnectState.Loading -> LoadingCard(modifier = Modifier.fillMaxWidth())
//                is DeviceConnectState.Success -> {
//
//                    VitalView(
//                        vitalIcon = Icons.Default.MonitorHeart,
//                        vitalValue = payload.heartRate,
//                        vitalLabel = "Heart rate",
//                        vitalUnit = " bpm"
//                    )
//                    VitalView(
//                        vitalIcon = Icons.Default.BatteryFull,
//                        vitalValue = payload.batteryLevel,
//                        vitalLabel = "Battery level",
//                        vitalUnit = " %"
//                    )
//                    VitalView(
//                        vitalIcon = Icons.Default.MonitorHeart,
//                        vitalValue = payload.spO2,
//                        vitalLabel = "Spo2",
//                        vitalUnit = " brpm"
//                    )
//                }
                is DeviceConnectState.Error -> TODO()
                DeviceConnectState.Idle -> {
                    // NO_OP
                }
            }
        }
    }
}