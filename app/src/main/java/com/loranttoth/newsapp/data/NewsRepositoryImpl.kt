package com.loranttoth.newsapp.data

import android.util.Log
import com.loranttoth.newsapp.data.datasource.NewsCacheDataSource
import com.loranttoth.newsapp.data.datasource.NewsLocalDataSource
import com.loranttoth.newsapp.data.datasource.NewsRemoteDataSource
import com.loranttoth.newsapp.data.model.New
import com.loranttoth.newsapp.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
    private val newsCacheDataSource: NewsCacheDataSource
    ): NewsRepository {
        override suspend fun getNews(country: String): List<New>? {
            return getNewsFromCache(country)
        }
        override suspend fun updateNews(country: String): List<New>? {
            val newListOfNews = getNewsFromAPI(country)
            newsLocalDataSource.clearAll()
            newsLocalDataSource.saveNewsToDB(newListOfNews)
            newsCacheDataSource.saveNewsToCache(newListOfNews)
            return newListOfNews
        }

        suspend fun getNewsFromAPI(country: String): List<New> {
            lateinit var newsList: List<New>

            try {
                val response = newsRemoteDataSource.getNews(country)
                val body = response.body()
                if (body != null){
                    newsList = body.news
                }

            }catch (exception: java.lang.Exception){
                Log.e("TAGGY", "error: "+exception.toString())

            }
            return newsList

        }



        suspend fun getNewsFromROOM(country: String): List<New>{
            lateinit var newsList: List<New>
            try {
                newsList = newsLocalDataSource.getNewsFromDB()
            }catch (exception: Exception){
                Log.e("TAGG", "error: "+exception.toString())

            }
            if (newsList.size> 0){
                return newsList
            }else{
                newsList = getNewsFromAPI(country)
                newsLocalDataSource.saveNewsToDB(newsList)

            }
            return newsList
        }

        private suspend fun getNewsFromCache(country: String): List<New>? {
            lateinit var newsList : List<New>

            try {
                newsList = newsCacheDataSource.getNewsFromCache()
            }catch (exception : Exception){

            }
            if (newsList.size > 0 ){
                return newsList
            }else{
                newsList = getNewsFromROOM(country)
                newsCacheDataSource.saveNewsToCache(newsList)
            }
            return newsList






        }
    }