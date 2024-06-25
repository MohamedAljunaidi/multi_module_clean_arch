package com.example.core.bases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.ErrorModel
import com.example.core.model.ResultException
import com.example.core.model.ServerExceptionType
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Created by Mohammad Aljunaidi on 01/01/2024.
 *
 * Main base [BaseViewModel]
 */
abstract class BaseViewModel : ViewModel() {

    val state: StateFlow<BaseViewState>
        get() = _state

    var _state =
        MutableStateFlow<BaseViewState>(BaseViewState.Idle)

    /**
     * The [launchCoroutine]
     *
     * handle the coroutine viewModelScope with coroutineExceptionHandler
     */

    open val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        viewModelScope.launch {
            _state.emit(
                BaseViewState.Error(
                    ResultException(
                        errorModel = ErrorModel(
                            cause = exception,
                            errorType = ServerExceptionType.UnExpectedError
                        )
                    )
                )
            )
        }
    }

    fun launchCoroutine(
        coroutineExceptionHandler: CoroutineExceptionHandler,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch(coroutineExceptionHandler) {
            block()
        }
    }
}
