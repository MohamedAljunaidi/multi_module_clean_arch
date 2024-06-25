package com.example.news.presentation.newsdetails

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
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.extension.getActivity
import com.example.news.domain.news.model.News
import com.example.theme.component.ScaffoldTopAppbar
import com.example.theme.theme.color
import com.google.gson.Gson

@Composable
internal fun NewsDetailsRoute(
    viewModel: NewsDetailsViewModel = hiltViewModel(),
    onBackBtnClick: () -> Unit,
    news: News.Article
) {
    NewsDetailsScreen(onBackBtnClick = onBackBtnClick,news=news)
}

@Composable
fun NewsDetailsScreen(
    onBackBtnClick: () -> Unit,
    news: News.Article
) {

    ScaffoldTopAppbar(
        title = "News Details",
        containerColor = MaterialTheme.color.secondaryBackground,
        onNavigationIconClick = onBackBtnClick
    ) {

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

            val modifier = Modifier
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Card(
                    modifier = modifier
                        .padding(bottom = 10.dp),
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
        }
    }


}



