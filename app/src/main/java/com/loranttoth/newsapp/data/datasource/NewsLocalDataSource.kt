package com.loranttoth.newsapp.data.datasource

import com.loranttoth.newsapp.data.model.New

interface NewsLocalDataSource {

    suspend fun getNewsFromDB(): List<New>

    suspend fun saveNewsToDB(news: List<New>)

    suspend fun clearAll()
}