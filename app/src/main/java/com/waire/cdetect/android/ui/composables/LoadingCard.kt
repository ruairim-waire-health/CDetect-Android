package com.waire.cdetect.android.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.waire.cdetect.android.ui.theme.Waire

@Composable
fun LoadingCard(
    modifier: Modifier
) {
    Card(
        modifier = modifier.aspectRatio(1.33f),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp
    ) {
        Box {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Waire
            )
        }
    }
}