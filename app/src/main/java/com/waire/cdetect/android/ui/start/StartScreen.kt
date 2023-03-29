package com.waire.cdetect.android.ui.start

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    viewModel: StartViewModel = hiltViewModel()
) {
    viewModel.testHilt()
}