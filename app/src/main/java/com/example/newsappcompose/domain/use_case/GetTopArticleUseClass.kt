package com.example.newsappcompose.domain.use_case

import com.example.newsappcompose.domain.model.ArticleModel
import com.example.newsappcompose.domain.repository.GetTopArticlesRepo
import com.example.newsappcompose.utils.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopArticleUseClass @Inject constructor(
    private val getTopArticlesRepo:
    GetTopArticlesRepo,
) {
    operator fun invoke(): Flow<Resource<List<ArticleModel>>> = flow {
        emit(Resource.Loading(""))
        try {
            emit(Resource.Success(getTopArticlesRepo.getTopArticles()))

        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }

    }
}