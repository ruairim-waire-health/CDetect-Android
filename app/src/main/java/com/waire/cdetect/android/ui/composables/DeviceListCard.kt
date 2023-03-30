package com.waire.cdetect.android.ui.composables

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.ui.theme.grid_1
import com.waire.cdetect.android.ui.theme.grid_2
import com.waire.cdetect.android.ui.theme.grid_4
import com.waire.cdetect.android.ui.theme.grid_5

@Composable
fun DeviceListCard(
    modifier: Modifier,
    devices: List<UiDevice>,
    onDeviceSelected: (device: UiDevice) -> Unit,
    navController: NavHostController,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Card(
        modifier = modifier.wrapContentHeight(),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = grid_1,
        shape = RoundedCornerShape(grid_5)
    ) {
        Column(
            modifier = Modifier.padding(all = grid_4)
        ) {

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
}