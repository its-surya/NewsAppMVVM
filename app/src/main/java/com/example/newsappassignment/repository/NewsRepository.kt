package com.example.newsappassignment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsappassignment.api.NewsAPI
import com.example.newsappassignment.models.News

class NewsRepository(private val newsAPI : NewsAPI ) {

    private val newsLiveData = MutableLiveData<News>()

    val news : LiveData<News>
        get() = newsLiveData

    suspend fun getNews(){
        val result = newsAPI.getNews("in")
        if(result?.body() != null){
            newsLiveData.postValue( result.body() )
        }
    }

}