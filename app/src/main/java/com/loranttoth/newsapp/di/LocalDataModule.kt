package com.loranttoth.newsapp.di

import com.loranttoth.newsapp.data.datasource.NewsLocalDataSource
import com.loranttoth.newsapp.data.datasourceImpl.NewsLocalDataSourceImpl
import com.loranttoth.newsapp.data.db.NewDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(newDao: NewDao):NewsLocalDataSource{
        return NewsLocalDataSourceImpl(newDao)
    }

}