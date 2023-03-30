package com.waire.cdetect.android.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiDevice(
    val name: String,
    val address: String,
    val rssi: Int
): Parcelable
