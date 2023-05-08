package com.loranttoth.newsapp.data.model

import com.google.gson.annotations.SerializedName

data class NewsModel(
    val available: Int,
    val news: List<New>,
    val number: Int,
    val offset: Int
)