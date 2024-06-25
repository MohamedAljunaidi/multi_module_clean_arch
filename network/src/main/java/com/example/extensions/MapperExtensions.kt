package com.example.extensions

import com.example.core.model.ErrorModel
import com.example.core.model.ServerExceptionType
import com.example.model.ApiErrors
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.ResponseBody
import java.lang.reflect.Type

inline fun <reified T> ResponseBody.getModel(): T? {
    return Gson().fromJson(this.string(), type<T>())
}

inline fun <reified T> type(): Type = object : TypeToken<T>() {}.type


fun ApiErrors?.toErrorModel(serverExceptionType: ServerExceptionType) =
    ErrorModel(
        errorType = serverExceptionType,
        errorDescription = this?.message
    )

fun Throwable?.toErrorModel(serverExceptionType: ServerExceptionType) =
    ErrorModel(cause = this, errorType = serverExceptionType)

