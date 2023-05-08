package com.example.newsappcompose.domain.use_case

import com.example.newsappcompose.domain.model.ArticleModel
import com.example.newsappcompose.domain.repository.NewsRepo
import com.example.newsappcompose.utils.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepoUseClass @Inject constructor(
    private val newsRepo:
    NewsRepo,
) {
    operator fun invoke(): Flow<Resource<List<ArticleModel>>> = flow {
        emit(Resource.Loading(""))
        try {
            emit(Resource.Success(newsRepo.getTopHeadlines()))

        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }

    }
}