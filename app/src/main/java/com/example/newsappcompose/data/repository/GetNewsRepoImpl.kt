package com.example.newsappcompose.data.repository

import com.example.newsappcompose.data.model.ArticleDTO
import com.example.newsappcompose.data.network.ApiService
import com.example.newsappcompose.domain.model.ArticleModel
import com.example.newsappcompose.domain.repository.GetTopArticlesRepo
import com.example.newsappcompose.mapper.toDomain
import com.example.newsappcompose.utils.SafeApiRequest
import javax.inject.Inject

class GetNewsRepoImpl @Inject constructor(private val apiService: ApiService) :
    GetTopArticlesRepo, SafeApiRequest() {
    override suspend fun getTopArticles(): List<ArticleModel> {
        val response = safeApiRequest { apiService.getTopArticles() }
        return toDomain(response.articles!! as List<ArticleDTO>)
    }

}