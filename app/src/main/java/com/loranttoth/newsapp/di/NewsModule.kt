package com.loranttoth.newsapp.di

import com.loranttoth.newsapp.domain.usecases.GetNewsUseCase
import com.loranttoth.newsapp.domain.usecases.UpdateNewsUseCase
import com.loranttoth.newsapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class NewsModule {
    @NewsScope
    @Provides
    fun provideNewsViewModelFactory(
        getNewsUseCase: GetNewsUseCase,
        updateNewsUseCase: UpdateNewsUseCase
    ): ViewModelFactory{

        return ViewModelFactory(
            getNewsUseCase,
            updateNewsUseCase
        )
    }
}