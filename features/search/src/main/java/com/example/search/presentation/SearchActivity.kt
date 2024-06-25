package com.example.search.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.extension.SetNavGraph
import com.example.search.navigation.searchNavigation
import com.example.theme.theme.JetPackComposeModularizationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeModularizationTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SetNavGraph(navController = navController) {
                        searchNavigation(
                            navController = navController, context
                        )
                    }
                }
            }
        }
    }
}
