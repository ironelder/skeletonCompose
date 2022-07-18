package com.ironelder.skeletoncompose.di

import com.ironelder.skeletoncompose.data.BookRemoteRepository
import com.ironelder.skeletoncompose.data.BookRemoteRepositoryImpl
import com.ironelder.skeletoncompose.data.SearchBookApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideSearchBookApi(@Named("retrofit_search_book") retrofit: Retrofit): SearchBookApi =
        retrofit.create()

    @Singleton
    @Provides
    fun provideSearchRepository(repositoryImpl: BookRemoteRepositoryImpl): BookRemoteRepository =
        repositoryImpl

}