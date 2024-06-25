package com.example.news.data.news.repository

import com.example.core.model.ResultWrapper
import com.example.extensions.tryRequest
import com.example.news.data.NewsService
import com.example.news.data.mapper.toNews
import com.example.news.domain.news.model.News
import com.example.news.domain.news.repository.INewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsService: NewsService
) : INewsRepository {

    override fun getNews(
        country: String, category: String, apiKey: String
    ): Flow<ResultWrapper<News?>> = flow {
        val result = tryRequest(
            request = {
                newsService.getNews(
                    country = country,
                    category = category,
                    apiKey = apiKey
                )
            },
            dataToDomain = { response ->
                response?.toNews()
            }
        )
        emit(result)
    }

}