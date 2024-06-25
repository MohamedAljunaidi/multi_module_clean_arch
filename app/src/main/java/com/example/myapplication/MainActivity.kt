package com.example.myapplication

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.direction.news.NewsDestinationEnum
import com.example.direction.news.NewsNavigator
import com.example.direction.search.SearchDestinationEnum
import com.example.direction.search.SearchNavigator
import com.example.extension.navigateToDirection
import com.example.theme.theme.JetPackComposeModularizationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        val scope = rememberCoroutineScope()
        val context = LocalContext.current

        LaunchedEffect(true) {
            // Simulate a long-running task (e.g., loading data, initializing resources)
            delay(3000L) // Wait for 3 seconds

            // Navigate to the main content after the splash screen is displayed
            scope.launch {
                NewsNavigator.navigateToDirection(
                    context,
                    destination = NewsDestinationEnum.News
                )
            }
            finish()
        }

        SplashScreen()
    }

    @Composable
    fun SplashScreen() {
        Surface(
            color = Color.Black, // Customize the background color of the splash screen
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "Localized description",
                )
            }
        }
    }
}
