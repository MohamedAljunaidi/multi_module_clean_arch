package com.example.news.data

import com.example.news.data.news.model.NewsResponse
import com.example.result.NetworkResult
import com.example.services.ApiManager
import javax.inject.Inject

class NewsService @Inject constructor(private val apiManager: ApiManager) {

    companion object {
        private const val COUNTRY_PARAMS = "country"
        private const val CATEGORY_PARAMS = "category"
        private const val API_KEY = "apiKey"

        private const val PATH_GET_NEWS =
            "top-headlines"

    }


    suspend fun getNews(
        country: String, category: String, apiKey: String
    ): NetworkResult<NewsResponse> {
        return apiManager.getRequest(
            PATH_GET_NEWS, queryParamsMap = mapOf(
                COUNTRY_PARAMS to country,
                CATEGORY_PARAMS to category,
                API_KEY to apiKey,
            )
        )
    }
}