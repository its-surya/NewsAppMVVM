package com.example.newsappassignment.api

import com.example.newsappassignment.models.News
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines?apiKey=c49ef6c8c3a1451b8d827cd617328fd1")
    suspend fun getNews( @Query("country") country : String ) : Response<News>

}