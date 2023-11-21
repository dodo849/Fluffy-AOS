package com.example.fluffy_aos.ui.home.component

import androidx.compose.runtime.Composable
import com.example.fluffy_aos.R
import com.example.fluffy_aos.ui.home.reusable.DiagnosisCardView


@Composable
fun EyeDiagnosisCard() {
    DiagnosisCardView(
        title = "AI 안구 진단",
        detail = "준비중 입니다. 조금만 기다려 주세요 ☺️",
        imageRes = R.drawable.dog_face,
        onClick = { /*TODO*/ }
    )
}