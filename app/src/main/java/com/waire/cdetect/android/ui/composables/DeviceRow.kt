package com.waire.cdetect.android.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.ui.theme.grid_1
import com.waire.cdetect.android.ui.theme.grid_5
import com.waire.cdetect.android.ui.theme.sp_4

@Composable
fun DeviceRow(device: UiDevice, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(grid_1)
            .clickable(onClick = onClick),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = grid_1,
        shape = RoundedCornerShape(grid_5)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    fontSize = sp_4,
                    text = device.name,
                )
                Text(device.address)
            }

            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "${device.rssi} dBm",
            )
        }
    }
}