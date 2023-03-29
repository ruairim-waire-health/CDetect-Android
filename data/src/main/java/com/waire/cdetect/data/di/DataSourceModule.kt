package com.waire.cdetect.data.di

import com.waire.cdetect.data.datasource.DeviceDataSourceImpl
import com.waire.cdetect.data.repository.DeviceRepositoryImpl
import com.waire.cdetect.domain.repository.DeviceDataSource
import com.waire.cdetect.domain.repository.DeviceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindDeviceRepository(impl: DeviceRepositoryImpl): DeviceRepository

    @Binds
    abstract fun bindDeviceDataSource(impl: DeviceDataSourceImpl): DeviceDataSource

}
