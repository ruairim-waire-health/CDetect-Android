package com.waire.cdetect.android.di

import com.waire.cdetect.data.annotation.AppScope
import com.waire.cdetect.data.annotation.IODispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @AppScope
    fun provideAppScope() = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @Provides
    @IODispatcher
    fun provideIODispatcher() = Dispatchers.IO
}
