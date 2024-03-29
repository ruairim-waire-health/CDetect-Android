package com.waire.cdetect.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.waire.cdetect.android.R
import com.waire.cdetect.android.mapper.UiMapper.toUiDevice
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.ui.composables.DeviceListCard
import com.waire.cdetect.android.ui.composables.LoadingCard
import com.waire.cdetect.android.ui.state.DeviceScanState
import com.waire.cdetect.android.ui.theme.*
import com.waire.cdetect.android.ui.viewmodel.SharedViewModel
import compose.icons.EvaIcons
import compose.icons.evaicons.Outline
import compose.icons.evaicons.outline.Bluetooth

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onDeviceSelected: (uiDevice: UiDevice) -> Unit,
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {
    Column(
        modifier = modifier.padding(vertical = grid_8, horizontal = grid_6),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val scanState = sharedViewModel.uiScanState.collectAsState().value

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = grid_4)
                .padding(grid_8),
        )
        when (scanState) {
            is DeviceScanState.Loading ->
                LoadingCard(modifier = Modifier.fillMaxWidth())
            is DeviceScanState.Success ->
                DeviceListCard(
                    modifier = Modifier.fillMaxWidth(),
                    devices = mutableListOf(scanState.devices.toUiDevice()),
                    onDeviceSelected = onDeviceSelected,
                    navController = navController
                )
            is DeviceScanState.Error -> {
                Text(text = "Oops!: ${scanState.exception.message}")
            }
            is DeviceScanState.Idle -> {
                // NO_OP
            }
            else -> {}
        }
        Spacer(modifier = Modifier.weight(1f))

        FloatingActionButton(
            modifier = Modifier.size(grid_21),
            onClick = { sharedViewModel.startScan() },
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Icon(
                imageVector = EvaIcons.Outline.Bluetooth,
                modifier = Modifier
                    .size(grid_18)
                    .padding(all = grid_5),
                contentDescription = stringResource(id = R.string.start_scan),
                tint = Waire
            )
        }
    }
}

@Preview
@Composable
fun Preview_NewIdeaCard() {
//    val idea = IdeaDomain(
//        name = "Learn to dance",
//        type = Type.Charity,
//        participantCount = 2,
//        price = 0.1f,
//        accessibility = 0.2f,
//        key = "234244",
//        link = "www.dance.com"
//    )
//    MaterialTheme {
//        NewIdeaCard(
//            modifier = Modifier.fillMaxWidth(),
//            idea = idea,
//            isFavourite = false,
//            onFavouriteClick = { },
//            onLinkClick = { }
//        )
//    }
}