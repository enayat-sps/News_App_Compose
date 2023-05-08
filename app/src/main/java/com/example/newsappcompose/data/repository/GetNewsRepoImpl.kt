package com.example.newsappcompose.data.repository

import com.example.newsappcompose.data.network.ApiService
import com.example.newsappcompose.domain.model.ArticleModel
import com.example.newsappcompose.domain.repository.NewsRepo
import com.example.newsappcompose.mapper.toDomain
import com.example.newsappcompose.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsRepoImpl @Inject constructor(private val apiService: ApiService) :
    NewsRepo, SafeApiRequest() {
    override suspend fun getTopHeadlines(): List<ArticleModel> {
        val response = safeApiRequest { apiService.getTopHeadlines() }
        return response.articles?.toDomain()!!
    }

}