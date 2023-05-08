package com.loranttoth.newsapp.data.datasourceImpl

import android.util.Log
import com.loranttoth.newsapp.data.datasource.NewsLocalDataSource
import com.loranttoth.newsapp.data.db.NewDao
import com.loranttoth.newsapp.data.model.New
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsLocalDataSourceImpl(private val newDao: NewDao): NewsLocalDataSource {
    override suspend fun getNewsFromDB(): List<New> {
        return newDao.getNews()
    }

    override suspend fun saveNewsToDB(news: List<New>) {
        CoroutineScope(Dispatchers.IO).launch {
            try{
            newDao.saveNews(news)
            }catch (exception: Exception) {
                Log.e("TAGG", "error: "+exception.toString())
            }
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            newDao.deleteAllNews()
        }
    }
}