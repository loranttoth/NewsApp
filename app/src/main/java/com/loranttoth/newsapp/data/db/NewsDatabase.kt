package com.loranttoth.newsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.loranttoth.newsapp.data.model.New

@Database(entities = [New::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase(){

    abstract fun newDao() : NewDao
}