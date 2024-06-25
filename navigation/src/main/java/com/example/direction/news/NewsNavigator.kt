package com.example.direction.news

import android.content.Context
import android.os.Bundle
import com.example.extension.startIntent
import com.example.navigation.bases.IBaseDestination
import com.example.navigation.bases.INavigatorDirection
import com.example.navigation.constants.NavigationConstants

object NewsNavigator : INavigatorDirection() {

    private const val NEWS_ACTIVITY_PACKAGE_NAME = "news.presentation"
    private const val NEWS_SCREEN_NAME = "NewsActivity"
    private const val FEATURE_NEWS_PATH =
        "${NavigationConstants.FEATURE_PATH}.$NEWS_ACTIVITY_PACKAGE_NAME"

    private const val NEWS_PACKAGE_NAME =
        "$FEATURE_NEWS_PATH.$NEWS_SCREEN_NAME"

    override var className: String = NEWS_PACKAGE_NAME

    override fun navigateTo(context: Context, data: Bundle?, destination: IBaseDestination?) {
        context.apply {
            startIntent(className, data, destination)
        }
    }
}
