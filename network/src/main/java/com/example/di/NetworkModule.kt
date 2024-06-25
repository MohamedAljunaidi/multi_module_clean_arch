package com.example.di

import com.example.core.BuildConfig
import com.example.services.ApiManager
import com.example.services.ApiRequests
import com.example.services.MultipartApiRequests
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(loggingInterceptor: LoggingInterceptor) =
        HttpLoggingInterceptor(loggingInterceptor).apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }

    @Singleton
    @Provides
    fun provideApiDao(
        retrofit: Retrofit
    ): ApiRequests {
        return NetworkFactory.create(retrofit)
    }

    @Singleton
    @Provides
    fun provideMultipartApiDao(
        retrofit: Retrofit
    ): MultipartApiRequests {
        return NetworkFactory.createMultipartApiRequests(retrofit)
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return NetworkFactory.getOkHttpClient(
            httpLoggingInterceptor
        )

    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return NetworkFactory.getRetrofit(okHttpClient)
    }


    @Singleton
    @Provides
    fun provideApiManager(
        services: ApiRequests, multipartServices: MultipartApiRequests,
    ): ApiManager {
        return ApiManager(services, multipartServices)
    }
}