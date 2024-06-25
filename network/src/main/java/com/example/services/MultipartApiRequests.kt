package com.example.services

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Url

@JvmSuppressWildcards
interface MultipartApiRequests {


    @POST
    suspend fun multipartRequest(
        @Url url: String,
        @HeaderMap headersMap: Map<String, String>? = mapOf(),
        @Body body: RequestBody,
    ): Response<ResponseBody>

}