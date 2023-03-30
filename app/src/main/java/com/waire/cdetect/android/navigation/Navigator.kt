package com.waire.cdetect.android.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Navigator(
    val path: String,
    val icon: ImageVector? = null
) {
    companion object {
        fun fromString(route: String): Navigator {
            return when (route) {
                Start.path -> Start
                Vitals.path -> Vitals
                else -> Home
            }
        }
    }

    object Home : Navigator("home")
    object Start : Navigator("start", Icons.Filled.Phone)
    object Vitals : Navigator("vitals", Icons.Filled.Person)

    val title = path.replaceFirstChar(Char::uppercase)
}