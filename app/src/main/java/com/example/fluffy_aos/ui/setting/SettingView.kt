package com.example.fluffy_aos.ui.setting

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fluffy_aos.funnel.Funnel
import com.example.fluffy_aos.funnel.Step
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun SettingView() {

    val survey: MutableMap<String, Any> = mutableMapOf()

    Funnel(
        survey = survey,
        steps = listOf(
            Step(
                name = "first",
                content = {
                    Button(onClick = { it("second", "ㅇㄴㄹㅇ") }) {
                        Text(text = "first")
                    }
                }
            ),
            Step(
                name = "second",
                content = {
                    Button(onClick = { it("second", "ㅇㄴㄹㅇㄹ") }) {
                        Text(text = "second")
                    }
                }
            ),
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SettingViewPreview() {
    FluffyAOSTheme {
        SettingView()
    }
}