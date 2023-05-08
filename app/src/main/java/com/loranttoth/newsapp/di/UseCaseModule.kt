package com.loranttoth.newsapp.di

import com.loranttoth.newsapp.domain.repository.NewsRepository
import com.loranttoth.newsapp.domain.usecases.GetNewsUseCase
import com.loranttoth.newsapp.domain.usecases.UpdateNewsUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository):GetNewsUseCase{
        return GetNewsUseCase(newsRepository)
    }

    @Provides
    fun provideUpdateNewsUseCase(newsRepository: NewsRepository):UpdateNewsUseCase{
        return UpdateNewsUseCase(newsRepository)
    }

}