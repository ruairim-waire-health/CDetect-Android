package com.waire.cdetect.android.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.waire.cdetect.android.R
import com.waire.cdetect.android.ui.composables.LoadingCard
import com.waire.cdetect.android.ui.state.DeviceConnectState
import com.waire.cdetect.android.ui.state.DeviceScanState
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
    val payload = sharedViewModel.cDetectPayload.value

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
        when(connectState) {
            is DeviceConnectState.Loading -> LoadingCard(modifier = Modifier.fillMaxWidth())
            is DeviceConnectState.Success -> {
                Text(text = payload.toString())
                Log.d("VitalsScreen", "VitalsScreen: $payload")
            }
            is DeviceConnectState.Error -> TODO()
            DeviceConnectState.Idle -> {
                // NO_OP
            }
        }
    }
}