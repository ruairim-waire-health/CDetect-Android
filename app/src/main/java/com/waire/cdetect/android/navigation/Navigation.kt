package com.waire.cdetect.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {

//    val viewModel: SharedViewModel = viewModel()

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
                    onDeviceSelected = { sharedViewModel.onDeviceSelectedUsingBoundedService(it) },
                    sharedViewModel = sharedViewModel,
                    navController = navController
                )
            }
            composable(Navigator.Vitals.path) {
                VitalsScreen(modifier = modifier, sharedViewModel, navController)
            }
        }
    }
}
