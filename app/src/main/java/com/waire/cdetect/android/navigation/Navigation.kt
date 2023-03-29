package com.waire.cdetect.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.waire.cdetect.android.ui.start.StartScreen

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
                StartScreen(modifier = modifier)
            }
//            composable(Navigator.Favourites.path) {
//                FavouritesScreen(modifier = modifier)
//            }
        }
    }
}
