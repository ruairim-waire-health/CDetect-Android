package com.waire.cdetect.domain.interactors

interface DeviceScanInteractor {

    suspend operator fun invoke(): Boolean
}