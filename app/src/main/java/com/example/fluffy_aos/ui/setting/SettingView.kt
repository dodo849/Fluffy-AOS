package com.example.fluffy_aos.ui.setting

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fluffy_aos.funnel.Funnel
import com.example.fluffy_aos.funnel.Step
import com.example.fluffy_aos.ui.bcs_diagnosis.component.BcsNumericQuestion
import com.example.fluffy_aos.ui.theme.FluffyAOSTheme

@Composable
fun SettingView() {

    val survey: MutableMap<String, Any> = mutableMapOf()

    Funnel(
        result = survey,
        steps = listOf(
            Step(
                name = "first",
                content = {
                    BcsNumericQuestion("Q1. 흉곽 둘레를 입력해주세요") {
                        it("second", "ㅇㄴㄹㅇ")
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