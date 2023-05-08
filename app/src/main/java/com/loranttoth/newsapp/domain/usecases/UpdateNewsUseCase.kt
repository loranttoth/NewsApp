package com.loranttoth.newsapp.domain.usecases

import com.loranttoth.newsapp.data.model.New
import com.loranttoth.newsapp.domain.repository.NewsRepository

class UpdateNewsUseCase(private val newsRepository: NewsRepository) {
        suspend fun execute(country: String): List<New>? = newsRepository.updateNews(country)
}