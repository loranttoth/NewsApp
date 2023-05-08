package com.loranttoth.newsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.loranttoth.newsapp.domain.usecases.GetNewsUseCase
import com.loranttoth.newsapp.domain.usecases.UpdateNewsUseCase

class MyViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase
) : ViewModel() {
    fun getNews(country: String) = liveData {
        val newsList = getNewsUseCase.execute(country)
        emit(newsList)
    }

    fun updateNews(country: String) = liveData {
        val newsList = updateNewsUseCase.execute(country)
        emit(newsList)
    }
}