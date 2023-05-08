package com.example.newsappcompose.domain.di

import com.example.newsappcompose.data.network.ApiService
import com.example.newsappcompose.data.repository.GetNewsRepoImpl
import com.example.newsappcompose.domain.repository.GetTopArticlesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {
    @Provides
    fun providesNewsRepo(apiService: ApiService): GetTopArticlesRepo {
        return GetNewsRepoImpl(apiService)
    }
}