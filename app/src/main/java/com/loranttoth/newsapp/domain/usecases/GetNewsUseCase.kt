package com.loranttoth.newsapp.domain.usecases

import com.loranttoth.newsapp.data.model.New
import com.loranttoth.newsapp.domain.repository.NewsRepository

class GetNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String): List<New>? = newsRepository.getNews(country)
}