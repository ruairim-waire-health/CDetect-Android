package com.waire.cdetect.android.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Navigator(
    val path: String,
    val icon: ImageVector? = null
) {
    companion object {
        fun fromString(route: String): Navigator {
            return when (route) {
                Start.path -> Start
                else -> Home
            }
        }
    }

    object Home : Navigator("home")
    object Start : Navigator("start", Icons.Filled.Phone)
    object Favourites : Navigator("profile", Icons.Filled.Person)

    val title = path.replaceFirstChar(Char::uppercase)
}