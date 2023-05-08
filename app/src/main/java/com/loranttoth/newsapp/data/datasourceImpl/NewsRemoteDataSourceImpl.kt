package com.loranttoth.newsapp.data.datasourceImpl

import com.loranttoth.newsapp.data.api.NewsApiService
import com.loranttoth.newsapp.data.datasource.NewsRemoteDataSource
import com.loranttoth.newsapp.data.model.NewsModel
import retrofit2.Response


class NewsRemoteDataSourceImpl(
    private val newsService: NewsApiService,
    private val apiKey: String,
) : NewsRemoteDataSource {
    override suspend fun getNews(country: String): Response<NewsModel> =
        newsService.getNews(apiKey, country, "publish-date", "DESC", "100")
}