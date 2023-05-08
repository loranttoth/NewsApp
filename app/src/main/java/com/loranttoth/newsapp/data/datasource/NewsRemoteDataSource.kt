package com.loranttoth.newsapp.data.datasource

import com.loranttoth.newsapp.data.model.NewsModel
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getNews(country: String) : Response<NewsModel>
}