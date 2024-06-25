package com.example.news.navigation

import androidx.activity.OnBackPressedDispatcher
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.news.presentation.news.NewsRoute
import com.example.news.presentation.newsdetails.NewsDetailsRoute
import com.example.navigation.constants.NavigationConstants
import com.example.navigation.constants.NavigationConstants.replaceParams
import com.example.news.domain.news.model.News
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun NavGraphBuilder.newsListNavigation(
    navController: NavHostController,
) {

    newsScreen(
        onNewsItemClick = navController::navigateToNewsDetailsScreen,
        onBackBtnClick = { backDispatcher ->
            backDispatcher?.onBackPressed()
        }
    )
    newsDetailsScreen(onBackBtnClick = {
        navController.navigateUp()
    })
}

fun NavGraphBuilder.newsScreen(
    onNewsItemClick: (News.Article) -> Unit,
    onBackBtnClick: (OnBackPressedDispatcher?) -> Unit,
) {
    composable(route = NavigationConstants.NEWS_PATH) {
        NewsRoute(
            onNewsItemClick = onNewsItemClick,
            onBackBtnClick = onBackBtnClick
        )
    }
}

fun NavGraphBuilder.newsDetailsScreen(
    onBackBtnClick: () -> Unit,
) {
    composable(
        route = NavigationConstants.NEWS_DETAILS_PATH,
        arguments = listOf(
            navArgument(
                name = "news"
            ) {
                type = NavType.StringType
                defaultValue = ""
            },
        )
    ) {
        val newsJsonString = it.arguments?.getString("news")
        val type = object : TypeToken<News.Article>() {}.type
        val news: News.Article = Gson().fromJson(newsJsonString, type)

        NewsDetailsRoute(
            onBackBtnClick = onBackBtnClick, news = news
        )
    }
}


fun NavController.navigateToNewsDetailsScreen(news: News.Article) {
    val article = Gson().toJson(news)
    navigate(
        replaceParams(
            NavigationConstants.NEWS_DETAILS_PATH,
            NavigationConstants.NEWS_PARAMS,
            article
        )
    )
}
