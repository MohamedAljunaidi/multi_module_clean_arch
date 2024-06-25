package com.example.result

import com.example.exceptions.NetworkException


sealed class NetworkResult<out T> {

    data class Success<T>(val data: T?) : NetworkResult<T>()

    data class Error(val error: NetworkException) : NetworkResult<Nothing>()

}