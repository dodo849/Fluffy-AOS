package com.example.fluffy_aos.ui.post

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun PostView(navController: NavController) {
    Column {
        Button(onClick = { navController.popBackStack() }) {
            Text("Go Back")
        }
        Text(
            text = "Hello zz!",
        )
    }

}