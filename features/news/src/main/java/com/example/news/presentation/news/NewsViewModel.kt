package com.example.news.presentation.news

import com.example.core.bases.BaseViewModel
import com.example.core.bases.BaseViewState
import com.example.core.model.ResultException
import com.example.core.model.ResultWrapper
import com.example.news.domain.news.model.News
import com.example.news.domain.news.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,

    ) : BaseViewModel() {

    private var _newsList: MutableStateFlow<ArrayList<News.Article>?> =
        MutableStateFlow(null)
    val newsList: StateFlow<ArrayList<News.Article>?> =
        _newsList.asStateFlow()

    init {
        getNews()
    }


    private fun getNews() {
        launchCoroutine(coroutineExceptionHandler) {
            val newsMap = mapOf(
                GetNewsUseCase.COUNTRY_PARAMS to "us",
                GetNewsUseCase.CATEGORY_PARAMS to "technology",
                GetNewsUseCase.API_KEY_PARAMS to "b9a8fe3160024abd947e154333305311"
            )

            getNewsUseCase.invoke(newsMap)
                .onStart {
                    _state.emit(BaseViewState.Loading)
                }
                .collectLatest {
                    when (it) {
                        is ResultWrapper.Error -> _state.emit(
                            BaseViewState.Error(
                                ResultException(it.error.errorModel)
                            )
                        )

                        is ResultWrapper.Success -> {
                            _newsList.emit(it.data?.articles)
                        }
                    }
                    _state.emit(BaseViewState.DataLoaded)
                }

        }
    }
}