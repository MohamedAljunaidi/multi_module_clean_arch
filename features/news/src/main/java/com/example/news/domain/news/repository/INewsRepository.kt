package com.example.news.domain.news.repository

import com.example.core.model.ResultWrapper
import com.example.news.domain.news.model.News
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    fun getNews(country: String, category: String): Flow<ResultWrapper<News?>>

}