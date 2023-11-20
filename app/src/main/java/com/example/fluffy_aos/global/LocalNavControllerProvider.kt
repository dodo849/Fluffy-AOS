package com.example.fluffy_aos.global

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController

@Composable
fun LocalNavControllerProvider(content: @Composable () -> Unit) {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        content()
    }
}
