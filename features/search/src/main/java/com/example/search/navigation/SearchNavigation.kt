package com.example.search.navigation

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.extension.getActivity
import com.example.search.presentation.SearchScreenRoute



fun NavGraphBuilder.searchNavigation(
    navController: NavHostController,
    context: Context,
) {
    searchScreen(
        onBackBtnClick = {
            context.getActivity()?.finish()
        }
    )
}

const val SearchRoute = "SearchRoute"

fun NavGraphBuilder.searchScreen(
    onBackBtnClick: () -> Unit,
) {
    composable(route = SearchRoute) {
        SearchScreenRoute(
            onBackBtnClick = onBackBtnClick
        )
    }
}