package com.example.newsappcompose.mapper

import com.example.newsappcompose.data.model.ArticleDTO
import com.example.newsappcompose.domain.model.ArticleModel

//
fun List<ArticleDTO>.toDomain(): List<ArticleModel> {
    return map {
        ArticleModel(
            author = it.author ?: "",
            content = it.content ?: "",
            description = it.description ?: "",
            publishedAt = it.publishedAt ?: "",
            title = it.title ?: "",
            urlToImage = it.urlToImage ?: "",
        )
    }
}

fun toDomain(list: List<ArticleDTO>): List<ArticleModel> {

    val articleModel = arrayListOf<ArticleModel>()

    list.forEach {
        articleModel.add(
            ArticleModel(
                author = it.author ?: "",
                content = it.content ?: "",
                description = it.description ?: "",
                publishedAt = it.publishedAt ?: "",
                title = it.title ?: "",
                urlToImage = it.urlToImage ?: "",
            )
        )
    }

    return articleModel

}

/*
fun List<ArticleDTO>.toDomain(): List<ArticleModel> {
    return map {
        ArticleModel(
            it.author ?: "",
            it.content ?: "",
            it.description ?: "",
            it.publishedAt ?: "",
            it.title ?: "",
            it.urlToImage ?: "",
        )
    }
}
*/

