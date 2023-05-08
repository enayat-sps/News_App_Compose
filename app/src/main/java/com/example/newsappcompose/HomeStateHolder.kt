package com.example.newsappcompose

import com.example.newsappcompose.domain.model.ArticleModel


data class HomeStateHolder(
    val isLoading: Boolean = false,
    val data: List<ArticleModel>? = null,
    val error: String = "",

    )
