package com.loranttoth.newsapp.data.datasource

import com.loranttoth.newsapp.data.model.New

interface NewsCacheDataSource {
    suspend fun getNewsFromCache(): List<New>

    suspend fun saveNewsToCache(news:List<New>)
}