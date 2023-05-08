package com.loranttoth.newsapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news")
data class New(
    @SerializedName("author")
    val author: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("publish_date")
    val publish_date: String,
    @SerializedName("sentiment")
    val sentiment: Double,
    @SerializedName("source_country")
    val source_country: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)