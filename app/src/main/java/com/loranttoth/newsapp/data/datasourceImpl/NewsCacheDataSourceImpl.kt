package com.loranttoth.newsapp.data.datasourceImpl

import com.loranttoth.newsapp.data.datasource.NewsCacheDataSource
import com.loranttoth.newsapp.data.model.New

class NewsCacheDataSourceImpl: NewsCacheDataSource {

    private var newsList = ArrayList<New>()

    override suspend fun getNewsFromCache(): List<New> {
        return newsList
    }

    override suspend fun saveNewsToCache(news: List<New>) {
        newsList.clear()
        newsList = ArrayList(news)
    }
}