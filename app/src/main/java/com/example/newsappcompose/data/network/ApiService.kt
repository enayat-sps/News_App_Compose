package com.example.newsappcompose.data.network

import com.example.newsappcompose.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "in",
        @Query("apiKey") apiKey: String = "eacefcc71ae04739bbe087cf17aab95b",
    ): Response<NewsDTO>

    @GET("everything")
    fun getEverything(
        @Query("q") q: String?,
        @Query("sources") sources: String?,
        @Query("domains") domains: String?,
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortBy: String?,
        @Query("pageSize") pageSize: Int?,
        @Query("page") page: Int?,
    ): Response<NewsDTO>

}