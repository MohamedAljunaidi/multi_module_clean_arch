package com.example.services

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Url

interface FormUrlEncodedApiRequests {

    @FormUrlEncoded
    @POST
    suspend fun postFormUrlEncodedRequest(
        @Url url: String,
        @HeaderMap headersMap: Map<String, String>? = mapOf(),
        @FieldMap fieldsMap: Map<String, String>? = mapOf()
    ): Response<ResponseBody>

}