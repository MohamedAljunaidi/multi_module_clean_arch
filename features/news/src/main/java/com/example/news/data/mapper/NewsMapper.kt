package com.example.news.data.mapper

import com.example.news.data.news.model.NewsResponse
import com.example.news.domain.news.model.News

internal fun NewsResponse.toNews(): News {
    val dataList = arrayListOf<News.Article>()
    this.articles?.map {
        dataList.add(
            News.Article(
                title = it?.title,
                name = it?.source?.name,
                author = it?.author,
                content = it?.content,
                description = it?.description,
                publishedAt = it?.publishedAt,
                url = it?.url,
                urlToImage = it?.urlToImage
            )
        )
    }

    return News(dataList)

}
