package com.waire.cdetect.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.waire.cdetect.android.navigation.Navigation
import com.waire.cdetect.android.navigation.Navigator
import com.waire.cdetect.android.ui.composables.BottomNavigationBar

@Composable
fun CDetectScaffold(modifier: Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()

    val currentNavigator by derivedStateOf {
        navBackStackEntry.value?.destination?.route
            ?.let(Navigator::fromString)
            ?: Navigator.Home
    }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigationBar(
                currentNavigator = currentNavigator,
                onNavigate = {
                    navController.navigate(it.path) {
                        launchSingleTop = true
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = modifier
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {
            Navigation(
                modifier = modifier,
                navController = navController
            )
        }
    }
}
