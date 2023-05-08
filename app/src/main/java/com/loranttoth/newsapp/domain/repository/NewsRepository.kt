package com.loranttoth.newsapp.domain.repository

import com.loranttoth.newsapp.data.model.New

interface NewsRepository {

    suspend fun getNews(country: String): List<New>?
    suspend fun updateNews(country: String): List<New>?
}
