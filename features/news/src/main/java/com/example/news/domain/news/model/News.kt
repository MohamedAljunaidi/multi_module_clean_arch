package com.example.news.domain.news.model

import androidx.annotation.Keep
import com.example.news.data.news.model.NewsResponse
import com.google.gson.annotations.SerializedName

@Keep
data class News(
    var articles: ArrayList<Article>? = arrayListOf(),
) {
    @Keep
    data class Article(
        var title: String? = "",
        var name: String? = "",
        var author: String? = "",
        var content: String? = "",
        var description: String? = "",
        var publishedAt: String? = "",
        var url: String? = "",
        var urlToImage: String? = "",
    )


}