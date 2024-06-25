package com.example.direction.search

import android.content.Context
import android.os.Bundle
import com.example.extension.startIntent
import com.example.navigation.bases.IBaseDestination
import com.example.navigation.bases.INavigatorDirection
import com.example.navigation.constants.NavigationConstants

object SearchNavigator : INavigatorDirection() {

    private const val SEARCH_ACTIVITY_PACKAGE_NAME = "search.presentation"
    private const val SEARCH_SCREEN_NAME = "SearchActivity"
    private const val FEATURE_SEARCH_PATH =
        "${NavigationConstants.FEATURE_PATH}.$SEARCH_ACTIVITY_PACKAGE_NAME"

    private const val SEARCH_PACKAGE_NAME =
        "$FEATURE_SEARCH_PATH.$SEARCH_SCREEN_NAME"

    override var className: String = SEARCH_PACKAGE_NAME

    override fun navigateTo(context: Context, data: Bundle?, destination: IBaseDestination?) {
        context.apply {
            startIntent(className, data, destination)
        }
    }
}
