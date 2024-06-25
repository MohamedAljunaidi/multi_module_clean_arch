package com.example.services

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.QueryMap
import retrofit2.http.Url

@JvmSuppressWildcards
interface ApiRequests {

    @GET
    suspend fun getRequest(
        @Url url: String,
        @HeaderMap headersMap: Map<String, String>? = mapOf(),
        @QueryMap queryParamsMap: Map<String, Any?>? = mapOf()
    ): Response<ResponseBody>

    @GET
    suspend fun getResponseBody(
        @Url url: String,
        @HeaderMap headersMap: Map<String, String>? = mapOf(),
        @QueryMap queryParamsMap: Map<String, Any?>? = mapOf()
    ): Response<ResponseBody>

    @POST
    suspend fun postRequest(
        @Url url: String,
        @HeaderMap headersMap: Map<String, String>? = mapOf(),
        @Body bodyMap: Map<String, Any?> = mapOf()
    ): Response<ResponseBody>

    @POST
    suspend fun postRequest(
        @Url url: String,
        @HeaderMap headersMap: Map<String, String>? = mapOf(),
        @Body body :Any
    ): Response<ResponseBody>

}