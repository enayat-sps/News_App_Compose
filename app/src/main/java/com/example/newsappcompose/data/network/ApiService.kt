package com.example.newsappcompose.data.network

import com.example.newsappcompose.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getTopArticles(
        @Query("country") country:String= "in",
        @Query("apiKey") apiKey:String= "eacefcc71ae04739bbe087cf17aab95b"
    ):Response<NewsDTO>

}