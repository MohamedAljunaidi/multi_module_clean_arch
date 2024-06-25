package com.example.services

import com.example.extensions.getModel
import com.example.extensions.map
import com.example.extensions.parseErrorResponse
import com.example.extensions.safeApiCall
import com.example.extensions.substitutePathParams
import com.example.extensions.toCompletable
import com.example.result.NetworkResult
import kotlinx.coroutines.runBlocking
import okhttp3.RequestBody
import okhttp3.ResponseBody
import javax.inject.Inject

class ApiManager @Inject constructor(
    val services: ApiRequests,
    val multipartServices: MultipartApiRequests,
) {

    suspend inline fun <reified T> getRequest(
        url: String,
        pathParams: Map<String, String>? = mapOf(),
        headersMap: Map<String, String>? = mapOf(),
        queryParamsMap: Map<String, Any?>? = mapOf()
    ): NetworkResult<T> =
        safeApiCall {
            services.getRequest(
                url = substitutePathParams(url, pathParams),
                headersMap = headersMap,
                queryParamsMap = queryParamsMap
            )
        }.map { response ->
                response?.body()?.getModel()
            }

    suspend inline fun getResponseBody(
        url: String,
        pathParams: Map<String, String>? = mapOf(),
        headersMap: Map<String, String>? = mapOf(),
        queryParamsMap: Map<String, Any?>? = mapOf()
    ): NetworkResult<ResponseBody> {
        val response = runBlocking {
            try {
                val success = services.getResponseBody(
                    url = substitutePathParams(url, pathParams),
                    headersMap = headersMap,
                    queryParamsMap = queryParamsMap
                )
                NetworkResult.Success(success.body())

            } catch (e: Exception) {
                NetworkResult.Error(e.parseErrorResponse())
            }
        }
        return response
    }


    suspend inline fun <reified T> postRequest(
        url: String,
        pathParams: Map<String, String>? = mapOf(),
        headersMap: Map<String, String>? = mapOf(),
        body: Any
    ): NetworkResult<T> =
        safeApiCall {
            services.postRequest(
                url = substitutePathParams(url, pathParams),
                headersMap = headersMap,
                body = body
            )
        }.map { response ->
                response?.body()?.getModel()
            }

    suspend inline fun <reified T> postRequest(
        url: String,
        pathParams: Map<String, String>? = mapOf(),
        headersMap: Map<String, String>? = mapOf(),
        bodyMap: Map<String, Any?> = mapOf()
    ): NetworkResult<T> =
        safeApiCall {
            services.postRequest(
                url = substitutePathParams(url, pathParams),
                headersMap = headersMap,
                bodyMap = bodyMap
            )
        }
            .map { response ->
                response?.body()?.getModel()
            }

    suspend fun postCompletableRequest(
        url: String,
        pathParams: Map<String, String>? = mapOf(),
        headersMap: Map<String, String>? = mapOf(),
        body: Any
    ): NetworkResult<Unit> =
        safeApiCall {
            services.postRequest(
                url = substitutePathParams(url, pathParams),
                headersMap = headersMap,
                body = body
            )
        }.toCompletable()

    suspend fun postCompletableRequest(
        url: String,
        pathParams: Map<String, String>? = mapOf(),
        headersMap: Map<String, String>? = mapOf(),
        bodyMap: Map<String, Any?> = mapOf()
    ): NetworkResult<Unit> =
        safeApiCall {
            services.postRequest(
                url = substitutePathParams(url, pathParams),
                headersMap = headersMap,
                bodyMap = bodyMap
            )
        }.toCompletable()

    suspend inline fun <reified T> multipartRequest(
        url: String,
        pathParams: Map<String, String>? = mapOf(),
        headersMap: Map<String, String>? = mapOf(),
        requestBody: RequestBody,
    ): NetworkResult<T> =
        safeApiCall {
            multipartServices.multipartRequest(
                url = substitutePathParams(url, pathParams),
                headersMap = headersMap,
                body = requestBody,
            )
        }
            .map { response ->
                response?.body()?.getModel()
            }

    suspend fun multipartCompletableRequest(
        url: String,
        pathParams: Map<String, String>? = mapOf(),
        headersMap: Map<String, String>? = mapOf(),
        requestBody: RequestBody,
    ): NetworkResult<Unit> =
        safeApiCall {
            multipartServices.multipartRequest(
                url = substitutePathParams(url, pathParams),
                headersMap = headersMap,
                body = requestBody,
            )
        }.toCompletable()

}