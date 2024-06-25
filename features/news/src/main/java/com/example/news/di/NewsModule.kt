package com.example.news.di

import com.example.news.data.NewsService
import com.example.news.data.news.repository.NewsRepository
import com.example.news.domain.news.repository.INewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class NewsModule {

    @Provides
    @ViewModelScoped
    fun getNewsRepository(newsService: NewsService): INewsRepository {
        return NewsRepository(newsService)
    }

}