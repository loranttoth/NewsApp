package com.loranttoth.newsapp.di

import com.loranttoth.newsapp.data.NewsRepositoryImpl
import com.loranttoth.newsapp.data.datasource.NewsCacheDataSource
import com.loranttoth.newsapp.data.datasource.NewsLocalDataSource
import com.loranttoth.newsapp.data.datasource.NewsRemoteDataSource
import com.loranttoth.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource,
        newsCacheDataSource: NewsCacheDataSource

    ):NewsRepository{

        return NewsRepositoryImpl(
            newsRemoteDataSource,
            newsLocalDataSource,
            newsCacheDataSource
        )

    }

}