package com.example.news.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.extension.SetNavGraph
import com.example.news.navigation.newsListNavigation
import com.example.theme.theme.JetPackComposeModularizationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : ComponentActivity() {
    private lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeModularizationTheme {
                 navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    SetNavGraph(navController = navController) {
                        newsListNavigation(
                            navController = navController
                        )

                    }
                }
            }
        }
    }

}
