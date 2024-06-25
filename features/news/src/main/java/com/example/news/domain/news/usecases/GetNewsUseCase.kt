package com.example.news.domain.news.usecases

import com.example.core.bases.BaseUseCase
import com.example.core.model.ResultWrapper
import com.example.news.domain.news.model.News
import com.example.news.domain.news.repository.INewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository: INewsRepository) :
    BaseUseCase<Map<String, String>, Flow<ResultWrapper<News?>>> {

        companion object{
             const val COUNTRY_PARAMS = "country"
             const val CATEGORY_PARAMS = "category"
        }
    override suspend fun invoke(params: Map<String, String>?): Flow<ResultWrapper<News?>> =
        repository.getNews(
            country = params?.get("country").toString(),
            category = params?.get("category").toString(),
        )
}