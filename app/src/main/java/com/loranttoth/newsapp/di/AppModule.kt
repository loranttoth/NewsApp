package com.loranttoth.newsapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(subcomponents = [NewsSubComponent::class])
class AppModule (private val context: Context){

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}