package com.waire.cdetect.domain.interactors

import android.util.Log
import javax.inject.Inject

class DeviceScanInteractorImpl @Inject constructor(): DeviceScanInteractor {
    override suspend fun invoke(): Boolean {
        Log.d(javaClass.simpleName, "hilt setup")
        return true
    }
}