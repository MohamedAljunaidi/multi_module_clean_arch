package com.example.exceptions

import com.example.core.model.ErrorModel
import com.example.core.model.ResultException
import com.example.core.model.ServerExceptionType
import com.example.extensions.toErrorModel
import com.example.model.ApiErrors

sealed class NetworkException(
    errorModel: ErrorModel? = null
) : ResultException(errorModel) {

    class NoInternetFoundException :
        NetworkException(ErrorModel(ServerExceptionType.NoInternetConnection))

    class ApiErrorException(
        serverExceptionType: ServerExceptionType = ServerExceptionType.UnExpectedError,
        apiErrors: ApiErrors? = null
    ) : NetworkException(
        errorModel = apiErrors.toErrorModel(serverExceptionType)
    )


    class UnknownException(
        cause: Throwable
    ) : NetworkException(cause.toErrorModel(ServerExceptionType.UnExpectedError))
}