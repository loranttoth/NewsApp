package com.loranttoth.newsapp.di

import com.loranttoth.newsapp.data.datasource.NewsCacheDataSource
import com.loranttoth.newsapp.data.datasourceImpl.NewsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {


    @Singleton
    @Provides
    fun provideNewsCacheDataSource(): NewsCacheDataSource{
        return NewsCacheDataSourceImpl()
    }
}