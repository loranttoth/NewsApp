package com.loranttoth.newsapp.data.api

import com.loranttoth.newsapp.data.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("search-news")
    suspend fun getNews(
        @Query(
            "api-key"
        ) apiKey: String,
        @Query(
            "source-countries"
        ) country: String,
        @Query(
            "sort"
        ) sortStr: String,
        @Query(
            "sort-direction"
        ) dir: String,
        @Query(
            "number"
        ) numberStr: String
    ) : Response<NewsModel>

    }
