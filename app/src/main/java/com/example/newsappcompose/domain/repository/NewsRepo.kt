package com.example.newsappcompose.domain.repository

import com.example.newsappcompose.domain.model.ArticleModel

interface NewsRepo {
    suspend fun getTopHeadlines(): List<ArticleModel>
}