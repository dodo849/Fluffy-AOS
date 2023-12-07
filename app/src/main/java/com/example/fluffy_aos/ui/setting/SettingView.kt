package com.example.fluffy_aos.ui.setting

import androidx.compose.foundation.clickable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fluffy_aos.global.LocalNavController
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun SettingView() {
    val navController = LocalNavController.current

    val survey: MutableMap<String, Any> = mutableMapOf()

    Text("준비중입니다")

    Button(onClick = {
        navController.navigate("onboarding_survey")
    }) {
        Text("온보딩 페이지 테스트")
    }

}

@Preview(showBackground = true)
@Composable
fun SettingViewPreview() {
    FluffyAOSTheme {
        SettingView()
    }
}