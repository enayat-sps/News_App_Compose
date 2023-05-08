package com.example.newsappcompose.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.HomeStateHolder
import com.example.newsappcompose.domain.use_case.NewsRepoUseClass
import com.example.newsappcompose.utils.Resource.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepoUseClass: NewsRepoUseClass) :
    ViewModel() {

    val articles = mutableStateOf(HomeStateHolder())


    init {
        getNewsArticles()
    }

    private fun getNewsArticles(){
        newsRepoUseClass().onEach {
            when(it){
                is Loading->{
                    articles.value = HomeStateHolder(isLoading = true)
                }
                is Success->{
                    articles.value = HomeStateHolder(data = it.data)
                }
                is Error->{
                    articles.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }


}