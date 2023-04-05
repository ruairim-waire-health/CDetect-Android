package com.waire.cdetect.android.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConnectionTopBar(isConnected: Boolean) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isConnected) Color.Green else Color.Red)
            .animateContentSize(animationSpec = tween(durationMillis = 300))
            .height(height = 28.dp),
        contentPadding = PaddingValues(start = 16.dp)
    ) {
        Text(
            text = if (isConnected) "Connected" else "Disconnected",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.White
            )
        )
    }
}
