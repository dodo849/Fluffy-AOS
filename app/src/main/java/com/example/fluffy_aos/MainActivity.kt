package com.example.fluffy_aos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        NavHost(navController = navController, startDestination = "first") {
            composable("first") { Greeting(navController) }
            composable("second") { GreetingPreview() }
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