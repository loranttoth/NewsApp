package com.loranttoth.newsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.loranttoth.newsapp.domain.usecases.GetNewsUseCase
import com.loranttoth.newsapp.domain.usecases.UpdateNewsUseCase

class ViewModelFactory(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(getNewsUseCase,updateNewsUseCase) as T
    }
}