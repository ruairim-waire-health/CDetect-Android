package com.waire.cdetect.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.waire.cdetect.android.ui.viewmodel.SharedViewModel
import com.waire.cdetect.android.ui.screens.StartScreen
import com.waire.cdetect.android.ui.screens.VitalsScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    val viewModel: SharedViewModel = viewModel()

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
                StartScreen(
                    modifier = modifier,
                    onDeviceSelected = { viewModel.onDeviceSelected(it) },
                    sharedViewModel = viewModel,
                    navController = navController
                )
            }
            composable(Navigator.Vitals.path) {
                VitalsScreen(modifier = modifier, viewModel, navController)
            }
        }
    }
}
