package com.ironelder.skeletoncompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
class CoroutineModule {

    @Provides
    fun providesIoDispatcher() = Dispatchers.IO

    @Provides
    fun providesMainDispatcher() = Dispatchers.Main.immediate

}