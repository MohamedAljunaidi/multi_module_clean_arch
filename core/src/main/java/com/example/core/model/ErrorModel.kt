package com.example.core.model

data class ErrorModel(
    var errorType: ServerExceptionType?=null,
    var errorDescription: String?=null,
    var cause: Throwable?=null,
)
