package com.example.news.data.news.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class NewsResponse(
    @SerializedName("articles")
    var articles: List<Article?>? = listOf(),
    @SerializedName("status")
    var status: String? = "",
    @SerializedName("totalResults")
    var totalResults: Int? = 0
) {
    @Keep
    data class Article(
        @SerializedName("author")
        var author: String? = "",
        @SerializedName("content")
        var content: String? = "",
        @SerializedName("description")
        var description: String? = "",
        @SerializedName("publishedAt")
        var publishedAt: String? = "",
        @SerializedName("source")
        var source: Source? = Source(),
        @SerializedName("title")
        var title: String? = "",
        @SerializedName("url")
        var url: String? = "",
        @SerializedName("urlToImage")
        var urlToImage: String? = ""
    ) {
        @Keep
        data class Source(
            @SerializedName("id")
            var id: String? = "",
            @SerializedName("name")
            var name: String? = ""
        )
    }
}