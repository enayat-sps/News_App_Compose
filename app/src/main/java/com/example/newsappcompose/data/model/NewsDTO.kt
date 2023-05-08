package com.example.newsappcompose.data.model

data class NewsDTO(
    val articles: List<ArticleDTO?>?,
    val status: String?,
    val totalResults: Int?,
)