package com.example.newsappcompose.domain.model

data class ArticleModel(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val urlToImage: String,
)