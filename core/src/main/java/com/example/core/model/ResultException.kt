package com.example.core.model

open class ResultException(
    val errorModel: ErrorModel? = null,
): RuntimeException(errorModel?.cause)