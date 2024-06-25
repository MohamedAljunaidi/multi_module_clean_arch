package com.example.search.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.direction.news.NewsNavigator
import com.example.extension.navigateToDirection
import com.example.theme.component.ScaffoldTopAppbar
import com.example.theme.theme.color
import com.example.direction.news.NewsDestinationEnum

@Composable
internal fun SearchScreenRoute(
    viewModel: SearchViewModel = hiltViewModel(),
    onBackBtnClick: () -> Unit,
) {
    SearchScreen(
        onBackBtnClick = onBackBtnClick
    )
}

@Composable
fun SearchScreen(
    onBackBtnClick: () -> Unit,
) {
    ScaffoldTopAppbar(
        title = "Search",
        containerColor = MaterialTheme.color.secondaryBackground,
        onNavigationIconClick = onBackBtnClick
    ) {


        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val context = LocalContext.current

            val modifier = Modifier
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("search", Modifier.clickable {
                        NewsNavigator.navigateToDirection(
                            context,
                            destination = NewsDestinationEnum.News,
                            data = bundleOf("name" to "mohamed")
                        )
                    })
                    Spacer(modifier = modifier.width(16.dp))
                }
            }
        }

    }
}





