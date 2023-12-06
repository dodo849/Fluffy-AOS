package com.example.fluffy_aos.ui.setting

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun SettingView() {

    val survey: MutableMap<String, Any> = mutableMapOf()

    Text("준비중입니다")

}

@Preview(showBackground = true)
@Composable
fun SettingViewPreview() {
    FluffyAOSTheme {
        SettingView()
    }
}