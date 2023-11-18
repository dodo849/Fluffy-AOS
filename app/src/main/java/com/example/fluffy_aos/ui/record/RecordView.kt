package com.example.fluffy_aos.ui.record

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.Greeting
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun RecordView(navController: NavController) {
    Text(
        text = "Hello zz!",
    )
}

@Preview(showBackground = true)
@Composable
fun RecordView() {
    FluffyAOSTheme {
        RecordView(rememberNavController())
    }
}