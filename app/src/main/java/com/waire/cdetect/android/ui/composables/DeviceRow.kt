package com.waire.cdetect.android.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.ui.theme.sp_4

@Composable
fun DeviceRow(device: UiDevice, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable(onClick = onClick)
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