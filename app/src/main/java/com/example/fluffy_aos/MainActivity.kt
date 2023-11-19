package com.example.fluffy_aos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.bottom_navigation.BottomNavigationBar
import com.example.fluffy_aos.ui.home.HomeView
import com.example.fluffy_aos.ui.post.PostView
import com.example.fluffy_aos.ui.record.RecordView
import com.example.fluffy_aos.ui.setting.SettingView
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalNavController provides navController) {
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar()
                    }
                ) { paddingValues ->
                    AppNavigation(navController, paddingValues)
                }
            }
        }
    }

    @Composable
    fun AppNavigation(navController: NavHostController, paddingValues: PaddingValues) {
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(paddingValues = paddingValues)
            ) {
                composable("home") { HomeView() }
                composable("record") { RecordView() }
                composable("post") { PostView() }
                composable("setting") { SettingView() }
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