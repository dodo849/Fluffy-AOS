package com.example.fluffy_aos.ui.setting

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun SettingView() {
    Text(
        text = "Hello zz!",
    )
}

@Preview(showBackground = true)
@Composable
fun SettingViewPreview() {
    FluffyAOSTheme {
        SettingView()
    }
}