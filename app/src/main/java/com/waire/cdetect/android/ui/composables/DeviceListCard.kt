package com.waire.cdetect.android.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.ui.theme.grid_2
import com.waire.cdetect.android.ui.theme.grid_4

@Composable
fun DeviceListCard(
    modifier: Modifier = Modifier,
    devices: List<UiDevice>,
    onDeviceSelected: (device: UiDevice) -> Unit,
    navController: NavHostController,
) {
    Column(modifier = Modifier.padding(all = grid_4)) {
        LazyColumn {
            items(devices.size) { index ->
                val device = devices[index]
                DeviceRow(device) {
                    onDeviceSelected(device)
                    navController.navigate("vitals")
                }
            }
        }
        if (devices.size > 1) Divider(startIndent = grid_2, thickness = 1.dp, color = Color.Gray)

    }
}