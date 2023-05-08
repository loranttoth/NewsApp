package com.loranttoth.newsapp.di

import android.content.Context
import androidx.room.Room
import com.loranttoth.newsapp.data.db.NewDao
import com.loranttoth.newsapp.data.db.NewsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): NewsDatabase{
        return Room.databaseBuilder(context,
            NewsDatabase::class.java,
            "newsclient").build()
    }

    @Singleton
    @Provides
    fun provideNewDAO(newsDatabase: NewsDatabase): NewDao{
        return newsDatabase.newDao()
    }
}