package com.loranttoth.newsapp.di

import com.loranttoth.newsapp.data.api.NewsApiService
import com.loranttoth.newsapp.data.datasource.NewsRemoteDataSource
import com.loranttoth.newsapp.data.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsService: NewsApiService):NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(
            newsService,
            apiKey
        )
    }

}