package com.example.newsappcompose.domain.repository

import com.example.newsappcompose.domain.model.ArticleModel

interface GetTopArticlesRepo {
    suspend fun getTopArticles(): List<ArticleModel>
}