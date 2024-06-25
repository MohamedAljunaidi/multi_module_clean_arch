package com.example.news.presentation.news

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.news.domain.news.model.News
import com.example.theme.component.ScaffoldTopAppbar
import com.example.theme.theme.color
import coil.compose.AsyncImage
import com.example.core.bases.BaseScreen
import com.example.direction.search.SearchDestinationEnum
import com.example.direction.search.SearchNavigator
import com.example.extension.navigateToDirection

@Composable
internal fun NewsRoute(
    viewModel: NewsViewModel = hiltViewModel(),
    onNewsItemClick: (News.Article) -> Unit,
    onBackBtnClick: (OnBackPressedDispatcher?) -> Unit,
) {
    val newsUiState by viewModel.newsList.collectAsStateWithLifecycle()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    BaseScreen(
        baseViewState = state,
        content = {
            NewsScreen(
                newsUiState = newsUiState,
                onBackBtnClick = {
                    onBackBtnClick.invoke(backDispatcher)
                },
                onNewsItemClick = onNewsItemClick
            )
        }
    )

}

@Composable
fun NewsScreen(
    newsUiState: List<News.Article>?,
    onNewsItemClick: (News.Article) -> Unit,
    onBackBtnClick: () -> Unit,
) {
    ScaffoldTopAppbar(
        title = "News List",
        containerColor = MaterialTheme.color.secondaryBackground,
        onNavigationIconClick = onBackBtnClick
    ) {
        val context = LocalContext.current
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) { _ ->

            LazyColumn {
                item {
                    Box(modifier = Modifier.padding(16.dp)){

                        OutlinedTextField(
                            value = "",
                            enabled = false,
                            onValueChange = { },
                            label = { Text("Search") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    SearchNavigator.navigateToDirection(
                                        context,
                                        destination = SearchDestinationEnum.SEARCH
                                    )

                                }
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
                items(items = newsUiState ?: emptyList()) { news ->
                    NewsListItem(
                        news = news,
                        onItemClick = onNewsItemClick
                    )
                }
            }
        }
    }

}

@Composable
private fun NewsListItem(
    modifier: Modifier = Modifier,
    news: News.Article,
    onItemClick: (News.Article) -> Unit
) {
    Card(
        modifier = modifier
            .padding(bottom = 10.dp)
            .clickable { onItemClick(news) },
        shape = RectangleShape
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                AsyncImage(
                    model = news.urlToImage,
                    contentDescription = "",
                    modifier = modifier
                        .size(80.dp)
                        .aspectRatio(1f)
                        .clip(RectangleShape)
                )

                Spacer(modifier = modifier.width(16.dp))
                Column {
                    Text(
                        text = news.title ?: "",
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = modifier.height(10.dp))

                    Text(text = news.name ?: "", style = MaterialTheme.typography.bodyLarge)
                }
            }

        }
    }
}



