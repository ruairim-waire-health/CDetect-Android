package com.waire.cdetect.domain.di

import com.waire.cdetect.domain.interactors.DeviceConnectInteractor
import com.waire.cdetect.domain.interactors.DeviceConnectInteractorImpl
import com.waire.cdetect.domain.interactors.DeviceScanInteractor
import com.waire.cdetect.domain.interactors.DeviceScanInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {
    @Binds
    abstract fun bindDeviceScanInteractor(impl: DeviceScanInteractorImpl): DeviceScanInteractor

    @Binds
    abstract fun bindDeviceConnectInteractor(impl: DeviceConnectInteractorImpl): DeviceConnectInteractor


}
