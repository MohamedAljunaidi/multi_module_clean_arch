package com.example.navigation.constants

object NavigationConstants {

    internal const val FEATURE_PATH = "com.example"

    // news
     const val NEWS_PARAMS = "{news}"
     const val NEWS_PATH = "homeScreenRoute"
     const val NEWS_DETAILS_PATH = "NewsDetailsRoute?news=$NEWS_PARAMS"

    // search
     const val SEARCH_ROUTE = "SearchRoute"



    fun replaceParams(path:String, key:String, value:String) =
        path.replace(key,value)


}