package com.waire.cdetect.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.waire.cdetect.android.models.UiDevice
import com.waire.cdetect.android.ui.start.StartScreen
import com.wairehealth.androiddevelopmentkit.Utilites.Log

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Navigator.Home.path
    ) {
        navigation(
            startDestination = Navigator.Start.path,
            route = Navigator.Home.path
        ) {
            composable(Navigator.Start.path) {
                StartScreen(modifier = modifier, onDeviceSelected = {
                    Log.d("Device found", it.name + it.address + it.rssi)
                })
            }
//            composable(Navigator.Favourites.path) {
//                FavouritesScreen(modifier = modifier)
//            }
        }
    }
}
