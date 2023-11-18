package com.example.fluffy_aos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.home.HomeView
import com.example.fluffy_aos.ui.post.PostView
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()

        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()
        CompositionLocalProvider(LocalNavController provides navController) {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomeView() }
                composable("post") { PostView(navController) }
            }
        }

    }
}

@Composable
fun Greeting(navController: NavController) {
    Text(
        text = "Hello zz!",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FluffyAOSTheme {
        Greeting(rememberNavController())
    }
}